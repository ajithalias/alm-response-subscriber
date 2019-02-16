/*
 * package com.wiley.alm.responsesubscriber.config;
 * 
 * 
 * 
 * import javax.jms.ConnectionFactory;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Primary; import
 * org.springframework.jms.core.JmsTemplate;
 * 
 * import com.tibco.tibjms.TibjmsConnectionFactory;
 * 
 * @Configuration public class JMSMessagingConfiguration {
 * 
 * private static final Logger LOGGER =
 * LogManager.getLogger(JMSMessagingConfiguration.class);
 * 
 * @Value("${jms.url.tibco}") private String defaultBrokerUrlTibco;
 * 
 * @Value("${jms.user.tibco}") private String jmsUserTibco;
 * 
 * @Value("${jms.passpord.tibco}") private String jmsPasswordTibco;
 * 
 * @Value("${jms.first.connection.delay.milisecond}") private int delay;
 * 
 * @Value("${jms.connection.attempt.timeout}") private int
 * connectionAttemptTimeout;
 * 
 * @Value("${jms.connection.attempt.count}") private int connectionAttemptCount;
 * 
 * @Bean
 * 
 * @Primary public ConnectionFactory getTibcoJmsConnectionFactory() {
 * LOGGER.info("Connecting Tibco EMS: "+this.defaultBrokerUrlTibco
 * +", and user is "+this.jmsUserTibco);
 * 
 * final TibjmsConnectionFactory connectionFactoryTib = new
 * TibjmsConnectionFactory(this.defaultBrokerUrlTibco);
 * connectionFactoryTib.setUserName(this.jmsUserTibco);
 * connectionFactoryTib.setUserPassword(this.jmsPasswordTibco);
 * connectionFactoryTib.setConnAttemptCount(connectionAttemptCount);
 * connectionFactoryTib.setConnAttemptDelay(this.delay);
 * connectionFactoryTib.setConnAttemptTimeout(connectionAttemptTimeout); return
 * connectionFactoryTib; }
 * 
 * @Bean public JmsTemplate jmsTemplateTibco() { final JmsTemplate templateTib =
 * new JmsTemplate();
 * templateTib.setConnectionFactory(getTibcoJmsConnectionFactory());
 * templateTib.setSessionAcknowledgeModeName("CLIENT_ACKNOWLEDGE"); return
 * templateTib; }
 * 
 * }
 */