package com.wiley.alm.responsesubscriber.converters;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.model.BodyTM;
import com.wiley.alm.responsesubscriber.model.HeaderTM;
import com.wiley.alm.responsesubscriber.model.Result;
import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;
import com.wiley.alm.responsesubscriber.model.SucessResponseRequest;
import com.wiley.alm.responsesubscriber.service.MessageProducer;

@Component
public class SucessResponseConverter implements Converter {

	private static final Logger LOGGER = LogManager.getLogger(SucessResponseConverter.class);

	private final String RECORD_TYPE="INBOUND_RESPONSE";
	

	public List<TargetResponseEvent> makeDtoForEventSubscriber(SucessResponseRequest responseRequest) throws Exception {
		LOGGER.info("started converting for the request " + responseRequest);

		List<TargetResponseEvent> targetResponseEvent = new ArrayList<TargetResponseEvent>();
		HeaderTM header = responseRequest.getHeader();
		BodyTM body = responseRequest.getBody();
		Result[] results = body.getResults();
		for (Result result : results) {
			TargetResponseEvent event = new TargetResponseEvent();
			event.setStatus(result.getOperationResult());
			event.setSource(header.getGeneratedBy());
			event.setTimestamp(String.valueOf(header.getGenerationDate()));
			event.setSourceReferenceId(result.getPrimaryObjectID());
			event.setRecordType(RECORD_TYPE);
			targetResponseEvent.add(event);
		}

		LOGGER.info("completed converting for the request " + responseRequest);
		return targetResponseEvent;
	}

	public SucessResponseRequest convertXMLToObjectForEventStore(final Message jsonMessage) throws JMSException {
		String messageData;
		TextMessage textMessage = (TextMessage) jsonMessage;
		messageData = textMessage.getText();

		JAXBContext jaxbContext;
		SucessResponseRequest sucessResponseRequest = null;
		try {
			jaxbContext = JAXBContext.newInstance(SucessResponseRequest.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(messageData);
			sucessResponseRequest = (SucessResponseRequest) unmarshaller.unmarshal(reader);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sucessResponseRequest;
	}

	@Override
	public List<TargetResponseEvent> convert(Message jsonMessage) throws Exception {
		SucessResponseRequest req = convertXMLToObjectForEventStore(jsonMessage);
		List<TargetResponseEvent> dto = makeDtoForEventSubscriber(req);
		return dto;
	}
}
