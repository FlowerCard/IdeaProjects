package com.huapai.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/19.
 */
@RestController
@RequestMapping("/producer")
public class MyKafkaProducerController {
    
    private static final String TOPIC_NAME = "my-replicated-topic";
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @GetMapping("/send")
    public String send(String message) {
        kafkaTemplate.send(TOPIC_NAME, "mykafkadata", message);
        return "success";
    }
    
}
