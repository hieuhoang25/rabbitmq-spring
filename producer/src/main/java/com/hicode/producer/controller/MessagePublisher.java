package com.hicode.producer.controller;

import com.hicode.producer.config.MQConfig;
import com.hicode.producer.dto.CustomMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MessagePublisher {
    private RabbitTemplate template;
    @PostMapping("/publish")
    public String publicMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTINGKEY,message);
        return "Message Published";
    }
}
