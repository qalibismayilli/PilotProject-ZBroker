package com.company.messagereceiverservice.service;

import com.company.messagereceiverservice.dto.MessageDto;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RequestPointMessageService {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;


    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    public RequestPointMessageService(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessageToSave(MessageDto messageDto) {
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, messageDto);
    }
}
