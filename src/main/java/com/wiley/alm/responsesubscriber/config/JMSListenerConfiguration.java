package com.wiley.alm.responsesubscriber.config;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class JMSListenerConfiguration {

	private final Logger logger = LoggerFactory.getLogger(JMSListenerConfiguration.class);
	@Autowired
	@Qualifier("getTibcoJmsConnectionFactory")
	private ConnectionFactory getTibcoJmsConnectionFactory;

	@Value("${jms.concurrent.count.max}")
	private int maxConcurrentConnection;

	@Value("${jms.concurrent.count.min}")
	private int minConcurrentConnection;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactoryTIBCO(
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factoryTib = new DefaultJmsListenerContainerFactory();
		configurer.configure(factoryTib, getTibcoJmsConnectionFactory);
		factoryTib.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		factoryTib.setSessionTransacted(true);

		return factoryTib;
	}
}
