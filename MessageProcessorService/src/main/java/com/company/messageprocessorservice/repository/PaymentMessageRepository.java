package com.company.messageprocessorservice.repository;

import com.company.messageprocessorservice.model.PaymentMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMessageRepository extends JpaRepository<PaymentMessage, String> {
}
