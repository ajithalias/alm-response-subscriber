package com.wiley.alm.responsesubscriber.service;

import java.util.List;
import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageFormatException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.converters.Converter;
import com.wiley.alm.responsesubscriber.converters.ConverterFactory;
import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;

@Component
public class AlmJmsReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlmJmsReceiver.class);
	private static final String MESSAGE_FORMAT_NOT_SUPPORTED = "Message Ignored - Not a TextMessage";

	@Value("${alm.backout.count.threshold}")
	private int backOutCountThresholdValue;

	@Autowired
	private ConverterFactory factory;

	@Autowired
	private MessageProducer producer;

	@JmsListener(destination = "${jms.receive.response.queue.name.tibco}", containerFactory = "jmsListenerContainerFactoryTIBCO", concurrency = "${jms.receive.response.queue.concurrency}")
	public void receiveResponseMessage(final Message message) throws JmsException {

		if (message instanceof TextMessage) {
			MDC.put("messageId", UUID.randomUUID().toString());
			try {
				String strReceivedMsg = ((TextMessage) message).getText();

				LOGGER.info("Received Response XML: {}", strReceivedMsg);
				Converter converter = factory.getConverter(isSuccess(strReceivedMsg));
				List<TargetResponseEvent> event = converter.convert(message);
				producer.sendMessage(event);

				LOGGER.info("Successfully completed all the operations");

			} catch (JMSException exception) {
				LOGGER.error("Exception occured while processing the response.... ", exception);
				checkThresholdAndLimitRetry(message, exception);
			} catch (Exception e) {
				LOGGER.error("Exception occured while converting the response.... ", e);

			}
		} else {
			LOGGER.error("Fulfillment: {}", MESSAGE_FORMAT_NOT_SUPPORTED);
			checkThresholdAndLimitRetry(message, new MessageFormatException(MESSAGE_FORMAT_NOT_SUPPORTED));
		}
	}

	private void checkThresholdAndLimitRetry(final Message message, final JMSException exception) throws JmsException {
		try {
			final int backOutCount = message.getIntProperty("JMSXDeliveryCount");
			if (backOutCount >= this.backOutCountThresholdValue) {
				LOGGER.info("Exceeding BackOut Count. Removing as poisonous");
				return;
			} else {
				LOGGER.info("Backout count of :" + this.backOutCountThresholdValue
						+ " not exceeded. Message will be retried");
				throw JmsUtils.convertJmsAccessException(exception);
			}
		} catch (final JMSException mexception) {
			LOGGER.error("Unable to limit message based on threshold");
		}
	}

	private boolean isSuccess(String xmlString) {

		return true;
		//can be expand if dto model changes

	}

}