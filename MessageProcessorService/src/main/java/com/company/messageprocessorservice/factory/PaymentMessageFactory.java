package com.company.messageprocessorservice.factory;

import com.company.messageprocessorservice.model.PaymentMessage;

public class PaymentMessageFactory implements MessageFactory{
    @Override
    public PaymentMessage createMessage(String message) {
        return new PaymentMessage(message);
    }
}
