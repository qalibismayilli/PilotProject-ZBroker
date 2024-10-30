package com.company.messageprocessorservice.model


import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator


@Entity
@Table(name = "order_messages")
data class OrderMessage @JvmOverloads constructor(
    @Id
    @UuidGenerator
    val id: String? = null,

    @Column(name = "message")
    val message: String?
)
