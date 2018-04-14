package com.example.springbootkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @KafkaListener(topics = "zou1")
    public void consumer(String message) {


        System.out.println(message);

    }


}























