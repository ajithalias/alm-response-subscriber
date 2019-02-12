/*
 * &copy; John Wiley &amp; Sons, Inc
 */
package com.wiley.alm.responsesubscriber.converters;

import java.util.EnumMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.model.EventType;


/**
 * Description
 *
 * @author amit26si00, created 31-Jan-2019
 */
@Component
public class ConverterFactory {
    private static final Logger LOGGER = LogManager.getLogger(ConverterFactory.class);
    
    @Autowired EnumMap<EventType, Class<?>> registeredConverters;
    
    public Class<?> getConverter(EventType eType) {
        if(registeredConverters.containsKey(eType.getAccessMethod())) {
            LOGGER.info("Found Converter for {} from list of registered converters", eType.getAccessMethod());
            return registeredConverters.get(eType.getAccessMethod());
        }

        throw new RuntimeException("No converter registered for event type " + eType.getAccessMethod());
    }
}
