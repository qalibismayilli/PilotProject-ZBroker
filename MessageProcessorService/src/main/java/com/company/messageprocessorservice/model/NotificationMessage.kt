package com.company.messageprocessorservice.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UuidGenerator

@Entity
@Table(name = "notification_messages")
data class NotificationMessage @JvmOverloads constructor(
    @Id
    @UuidGenerator
    val id: String? = null,

    @Column(name = "message")
    val message: String?
)
