package com.cupid.joalarm.chat.controller;

import com.cupid.joalarm.chat.dto.ChatMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messageTemplate;

    @MessageMapping("api/chat/message")
    public void message(ChatMessageDTO message) {
        if (ChatMessageDTO.MessageType.JOIN.equals(message.getType())) {
            message.setMessage((message.getSender() + "님 입장"));
        }
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
        messageTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
