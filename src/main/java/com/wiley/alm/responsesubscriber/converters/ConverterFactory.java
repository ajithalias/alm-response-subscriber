/*
 * 
 */
package com.wiley.alm.responsesubscriber.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ConverterFactory {
	private static final Logger LOGGER = LogManager.getLogger(ConverterFactory.class);

	@Autowired
	ConverterImpl sucessResponseConverter;
	

	public  Converter getConverter(boolean type) {
		if (type) {
			LOGGER.info("Recived request is of sucesss");
			return sucessResponseConverter;
		}
		//can be expanded later if requiered
		throw new RuntimeException("No converter registered for event type ");
	}
}
