package com.company.messageprocessorservice.service;

import com.company.messageprocessorservice.dto.MessageDto;
import com.company.messageprocessorservice.factory.MessageFactory;
import com.company.messageprocessorservice.factory.MessageFactoryProvider;
import com.company.messageprocessorservice.model.NotificationMessage;
import com.company.messageprocessorservice.model.OrderMessage;
import com.company.messageprocessorservice.model.PaymentMessage;
import com.company.messageprocessorservice.repository.NotificationMessageRepository;
import com.company.messageprocessorservice.repository.OrderMessageRepository;
import com.company.messageprocessorservice.repository.PaymentMessageRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageService {
    private final NotificationMessageRepository notificationMessageRepository;
    private final OrderMessageRepository orderMessageRepository;
    private final PaymentMessageRepository paymentMessageRepository;

    public MessageService(NotificationMessageRepository notificationMessageRepository,
                          OrderMessageRepository orderMessageRepository,
                          PaymentMessageRepository paymentMessageRepository) {
        this.notificationMessageRepository = notificationMessageRepository;
        this.orderMessageRepository = orderMessageRepository;
        this.paymentMessageRepository = paymentMessageRepository;
    }

//    public void saveMessage(@NotNull MessageDto request) {
//
//        switch (Objects.requireNonNull(request.getMessageType())) {
//            case ORDER:
//                OrderMessage orderMessage = new OrderMessage(request.getMessage());
//                orderMessageRepository.save(orderMessage);
//                break;
//
//            case PAYMENT:
//                PaymentMessage paymentMessage = new PaymentMessage(request.getMessage());
//                paymentMessageRepository.save(paymentMessage);
//                break;
//
//            case NOTIFICATION:
//                NotificationMessage notificationMessage = new NotificationMessage(request.getMessage());
//                notificationMessageRepository.save(notificationMessage);
//                break;
//        }
//    }

    public void saveMessage(MessageDto request) {
        MessageFactory factory = MessageFactoryProvider.getFactory(Objects.requireNonNull(request.getMessageType()));
        Object message = factory.createMessage(request.getMessage());

        if (message instanceof OrderMessage) {
            orderMessageRepository.save((OrderMessage) message);
        } else if (message instanceof PaymentMessage) {
            paymentMessageRepository.save((PaymentMessage) message);
        } else if (message instanceof NotificationMessage) {
            notificationMessageRepository.save((NotificationMessage) message);
        }
    }

}
