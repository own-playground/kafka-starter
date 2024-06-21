package com.tally.kafkaproducer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Publisher {

    private final Logger log = Logger.getLogger(Publisher.class.getName());

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Publisher(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish")
    public void send(@RequestParam("message") String message) {
        log.info("Sending message: " + message);

        kafkaTemplate.send("topic_1", message);
    }
}
