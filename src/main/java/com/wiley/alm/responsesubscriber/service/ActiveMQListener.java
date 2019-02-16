/*
 * package com.wiley.alm.responsesubscriber.service;
 * 
 * import java.io.StringWriter; import java.util.Date;
 * 
 * import javax.jms.JMSException; import javax.jms.Message; import
 * javax.jms.TextMessage; import javax.xml.bind.JAXBContext; import
 * javax.xml.bind.JAXBException; import javax.xml.bind.Marshaller;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import
 * org.springframework.jms.annotation.JmsListener; import
 * org.springframework.messaging.handler.annotation.SendTo; import
 * org.springframework.stereotype.Component;
 * 
 * import com.wiley.alm.responsesubscriber.model.BodyTM; import
 * com.wiley.alm.responsesubscriber.model.HeaderTM; import
 * com.wiley.alm.responsesubscriber.model.Result; import
 * com.wiley.alm.responsesubscriber.model.TargetResponseRequest;
 * 
 * @Component public class ActiveMQListener {
 * 
 * private static final Logger LOGGER =
 * LogManager.getLogger(ActiveMQListener.class);
 * 
 * @JmsListener(destination = "inbound.queue")
 * 
 * @SendTo("outbound.queue") public Message receiveMessage(final Message
 * jsonMessage) throws JMSException { String messageData = null;
 * System.out.println(); LOGGER.info("Received message ", jsonMessage); if
 * (jsonMessage instanceof TextMessage) {
 * LOGGER.info("Received Correct Format response"); } else { throw new
 * JMSException("Invalid Format"); }
 * 
 * return jsonMessage; }
 * 
 * 
 * 
 * private static void jaxbObjectToXML(TargetResponseRequest request) { try { //
 * Create JAXB Context JAXBContext jaxbContext =
 * JAXBContext.newInstance(TargetResponseRequest.class);
 * 
 * // Create Marshaller Marshaller jaxbMarshaller =
 * jaxbContext.createMarshaller();
 * 
 * // Required formatting??
 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 * 
 * // Print XML String to Console StringWriter sw = new StringWriter();
 * 
 * // Write XML to StringWriter jaxbMarshaller.marshal(request, sw);
 * 
 * // Verify XML Content String xmlContent = sw.toString();
 * System.out.println(xmlContent);
 * 
 * } catch (JAXBException e) { e.printStackTrace(); } }
 * 
 * public static void main(String[] args) { TargetResponseRequest req = new
 * TargetResponseRequest(); HeaderTM headerTM = new HeaderTM();
 * headerTM.setGeneratedBy("gen"); headerTM.setGenerationDate(new Date());
 * 
 * Result[] results = new Result[1]; BodyTM bodyTM = new BodyTM(); Result result
 * = new Result(); result.setOperationResult("SUCCESS"); results[0] = result;
 * bodyTM.setResults(results);
 * 
 * req.setBody(bodyTM); req.setHeader(headerTM); jaxbObjectToXML(req); } }
 */