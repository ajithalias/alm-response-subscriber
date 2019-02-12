package com.wiley.alm.responsesubscriber.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;

import com.wiley.alm.responsesubscriber.converters.ResponseEventConverter;
import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;
import com.wiley.alm.responsesubscriber.model.TargetResponseRequest;

public class MessageListener {

	private static final Logger LOGGER = LogManager.getLogger(MessageListener.class);

	private final ResponseEventConverter converter;
	private final MessageProducer producer;

	public MessageListener(ResponseEventConverter converter, MessageProducer producer) {
		this.converter = converter;
		this.producer = producer;
	}

	@JmsListener(destination = "queue_name")
	public void receiveMessage(TargetResponseRequest request) {

		LOGGER.info("recieved the message " + request);
		try {
			List<TargetResponseEvent> targetResponseEvents = converter.convert(request);

			for (TargetResponseEvent event : targetResponseEvents) {
				LOGGER.info("sending message to kafka " + request);
				producer.sendMessage(event);
				LOGGER.info("message sent to kafka " + request);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

}
