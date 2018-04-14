package com.example.springbootkafka.controller;


import com.example.springbootkafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@RestController
public class KafkaController {


    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value = "/message/send")
    private String sendMessage(@RequestParam String message) {


        kafkaTemplate.send("zou1", 0, message);

        return message;

    }

    @PostMapping(value = "/user/save")

    public User saveUser(@RequestBody User user) {


        kafkaTemplate.send("zou-users", 0, user);


        return user;
    }


}


























