package com.tally.kafkaconsumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "topic_1", groupId = "group_1")
    public void listener(final Object record) {
        System.out.println("record = " + record);
    }

}
