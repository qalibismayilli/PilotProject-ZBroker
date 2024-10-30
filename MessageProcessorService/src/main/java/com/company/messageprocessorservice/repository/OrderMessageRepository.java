package com.company.messageprocessorservice.repository;

import com.company.messageprocessorservice.model.OrderMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMessageRepository extends JpaRepository<OrderMessage, String> {
}
