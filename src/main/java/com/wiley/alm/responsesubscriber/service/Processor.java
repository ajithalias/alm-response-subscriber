package com.wiley.alm.responsesubscriber.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Processor {
    String INPUT = "input-channel";
    String OUTPUT = "output-channel";

    @Input(INPUT)
    SubscribableChannel inbound();

    @Output(OUTPUT)
    MessageChannel outbound();
}
