package com.company.messageprocessorservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    @Value("${sample.rabbitmq.exchange}")
    String exchange;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue firstStepQueue(){
        return new Queue(queueName, false);
    }


    @Bean
    Binding binding(Queue firstStepQueue, DirectExchange exchange){
        return BindingBuilder.bind(firstStepQueue).to(exchange).with(routingKey);
    }


    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener((message) -> {
            String messageBody = new String(message.getBody());
            System.out.println("Received message: " + messageBody);
        });
        return container;
    }
}