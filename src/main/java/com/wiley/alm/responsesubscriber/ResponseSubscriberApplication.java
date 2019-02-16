package com.wiley.alm.responsesubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.jms.annotation.EnableJms;

import com.wiley.alm.responsesubscriber.service.Processor;


@SpringBootApplication
@EnableBinding(Processor.class)
@EnableJms
public class ResponseSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseSubscriberApplication.class, args);
	}

}

