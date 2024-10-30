package com.company.messageprocessorservice.factory;

import com.company.messageprocessorservice.dto.MessageType;

public class MessageFactoryProvider {
    public static MessageFactory getFactory(MessageType messageType) {
        switch (messageType) {
            case ORDER:
                return new OrderMessageFactory();
            case PAYMENT:
                return new PaymentMessageFactory();
            case NOTIFICATION:
                return new NotificationMessageFactory();
            default:
                throw new IllegalArgumentException("Unknown message type: " + messageType);
        }
    }
}
