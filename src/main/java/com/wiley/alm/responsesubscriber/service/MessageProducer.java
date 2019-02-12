
package com.wiley.alm.responsesubscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;

@Service
public class MessageProducer {

	@Autowired
	private Processor processor;

	public void sendMessage(TargetResponseEvent targetResponseEvent) {
		MessageChannel messageChannel = processor.outbound();
		messageChannel.send(MessageBuilder.withPayload(targetResponseEvent)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.setHeader("X-MessageType", "auditEvent").build());
	}

}
