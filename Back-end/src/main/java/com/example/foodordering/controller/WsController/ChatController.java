package com.example.foodordering.controller.WsController;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class ChatController {
    @MessageMapping("/hello")
    @SendTo("/topic/thinh")
    public String greeting(String hello){
        return "hello" + hello;
    }
}

