package com.wiley.alm.responsesubscriber.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.converters.ResponseEventConverter;
import com.wiley.alm.responsesubscriber.model.BodyTM;
import com.wiley.alm.responsesubscriber.model.HeaderTM;
import com.wiley.alm.responsesubscriber.model.Result;
import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;
import com.wiley.alm.responsesubscriber.model.TargetResponseRequest;

@Component
public class Listener {

	@Autowired
	private MessageProducer messageProducer;

	@Autowired
	private ResponseEventConverter converter;

	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		String response = null;
		if (jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessage;
			messageData = textMessage.getText();

			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(TargetResponseRequest.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				StringReader reader = new StringReader(messageData);
				TargetResponseRequest header = (TargetResponseRequest) unmarshaller.unmarshal(reader);
				List<TargetResponseEvent> event;

				event = converter.convert(header);

				messageProducer.sendMessage(event);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return response;
	}

	private static void jaxbObjectToXML(TargetResponseRequest request) {
		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(TargetResponseRequest.class);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(request, sw);

			// Verify XML Content
			String xmlContent = sw.toString();
			System.out.println(xmlContent);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TargetResponseRequest req = new TargetResponseRequest();
		HeaderTM headerTM = new HeaderTM();
		headerTM.setGeneratedBy("gen");
		headerTM.setGenerationDate(new Date());

		Result[] results = new Result[1];
		BodyTM bodyTM = new BodyTM();
		Result result = new Result();
		result.setOperationResult("SUCCESS");
		results[0] = result;
		bodyTM.setResults(results);

		req.setBody(bodyTM);
		req.setHeader(headerTM);
		jaxbObjectToXML(req);
	}
}
