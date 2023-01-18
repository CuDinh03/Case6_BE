package com.example.casestudy6.controller;

import com.example.casestudy6.model.Chat;
import com.example.casestudy6.model.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/public")
    public void greeting(ChatRoom chatRoom) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public", new Chat(chatRoom.getAccountName() +" : " + chatRoom.getContent()));
    }
}
