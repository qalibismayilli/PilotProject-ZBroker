package com.company.messageprocessorservice.api;

import com.company.messageprocessorservice.dto.MessageDto;
import com.company.messageprocessorservice.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messageController/v1")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/saveMessage")
    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public ResponseEntity<Void> saveMessage(@RequestBody MessageDto dto){
        messageService.saveMessage(dto);
        return ResponseEntity.ok().build();
    }

}
