package com.hicode.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageService {
    public static final String QUEUE= "message_queue";
    @RabbitListener(queues = QUEUE)
    public void listener(CustomMessage message){
        log.info("----Received----");
        log.info("message: {}", message);
    }
}
