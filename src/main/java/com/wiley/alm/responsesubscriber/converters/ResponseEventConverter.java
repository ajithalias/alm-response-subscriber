package com.wiley.alm.responsesubscriber.converters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wiley.alm.responsesubscriber.model.BodyTM;
import com.wiley.alm.responsesubscriber.model.HeaderTM;
import com.wiley.alm.responsesubscriber.model.Result;
import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;
import com.wiley.alm.responsesubscriber.model.TargetResponseRequest;

@Component
public class ResponseEventConverter implements Converter<TargetResponseRequest, List<TargetResponseEvent>> {

	private static final Logger LOGGER = LogManager.getLogger(ResponseEventConverter.class);

	@Override
	public List<TargetResponseEvent> convert(TargetResponseRequest responseRequest) throws Exception {
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
			event.setEntityId(result.getPrimaryObjectID());
			targetResponseEvent.add(event);
		}

		LOGGER.info("completed converting for the request " + responseRequest);
		return targetResponseEvent;
	}

}
