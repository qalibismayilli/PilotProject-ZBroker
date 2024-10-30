package com.company.messageprocessorservice.repository;

import com.company.messageprocessorservice.model.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationMessageRepository extends JpaRepository<NotificationMessage, String> {
}
