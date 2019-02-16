/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.alm.responsesubscriber.converters;

import java.util.EnumMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.model.SucessResponseRequest;

/**
 * Description
 *
 * @author amit26si00, created 31-Jan-2019
 */

@Component
public class ConverterFactory {
	private static final Logger LOGGER = LogManager.getLogger(ConverterFactory.class);

	@Autowired
	SucessResponseConverter sucessResponseConverter;
	

	public  Converter getConverter(boolean type) {
		if (type) {
			LOGGER.info("Recived request is of sucesss");
			return sucessResponseConverter;
		}

		throw new RuntimeException("No converter registered for event type ");
	}
}
