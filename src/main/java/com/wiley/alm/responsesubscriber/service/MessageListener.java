/*
 * package com.wiley.alm.responsesubscriber.service;
 * 
 * import java.util.Map;
 * 
 * import javax.jms.JMSException; import javax.jms.TextMessage;
 * 
 * import org.apache.activemq.Message; import
 * org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
 * import org.springframework.jms.annotation.JmsListener; import
 * org.springframework.messaging.handler.annotation.SendTo;
 * 
 * import com.wiley.alm.responsesubscriber.converters.ResponseEventConverter;
 * 
 * public class MessageListener {
 * 
 * private static final Logger LOGGER =
 * LogManager.getLogger(MessageListener.class);
 * 
 * private final ResponseEventConverter converter; private final MessageProducer
 * producer;
 * 
 * public MessageListener(ResponseEventConverter converter, MessageProducer
 * producer) { this.converter = converter; this.producer = producer; }
 * 
 * @JmsListener(destination = "test2") public void
 * receiveMessage(TargetResponseRequest request) {
 * 
 * LOGGER.info("recieved the message " + request); try {
 * List<TargetResponseEvent> targetResponseEvents = converter.convert(request);
 * 
 * for (TargetResponseEvent event : targetResponseEvents) {
 * LOGGER.info("sending message to kafka " + request);
 * producer.sendMessage(event); LOGGER.info("message sent to kafka " + request);
 * } } catch (Exception e) { LOGGER.error(e.getMessage()); }
 * 
 * @JmsListener(destination = "test2") //@SendTo("outbound.topic") public String
 * receiveMessageFromTopic(final Message jsonMessage) throws JMSException {
 * String messageData = null; System.out.println("Received message " +
 * jsonMessage); String response = null; if(jsonMessage instanceof TextMessage)
 * { TextMessage textMessage = (TextMessage)jsonMessage; messageData =
 * textMessage.getText(); //Map map = new Gson().fromJson(message, Map.class);
 * //response = "Hello " + map.get("name"); } return response; }
 * 
 * }
 * 
 * 
 */