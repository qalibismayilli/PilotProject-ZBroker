package com.company.messageprocessorservice.factory;

import com.company.messageprocessorservice.model.OrderMessage;

public class OrderMessageFactory implements MessageFactory{
    @Override
    public OrderMessage createMessage(String message) {
        return new OrderMessage(message);
    }
}
