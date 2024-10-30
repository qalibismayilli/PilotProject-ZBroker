package com.company.messagereceiverservice.api;

import com.company.messagereceiverservice.dto.MessageDto;
import com.company.messagereceiverservice.service.RequestPointMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/requestPointController")
public class RequestPointMessageController {

    private final RequestPointMessageService requestPointMessageService;

    public RequestPointMessageController(RequestPointMessageService requestPointMessageService) {
        this.requestPointMessageService = requestPointMessageService;
    }

    @PostMapping("/sendMessageToSave")
    public void sendMessageToSave(@RequestBody MessageDto messageDto){
        requestPointMessageService.sendMessageToSave(messageDto);
    }
}
