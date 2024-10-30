package com.company.messageprocessorservice.factory;

import com.company.messageprocessorservice.model.NotificationMessage;

public class NotificationMessageFactory implements MessageFactory{
    @Override
    public NotificationMessage createMessage(String message) {
        return new NotificationMessage(message);
    }
}
