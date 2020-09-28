package com.project.my_collections.controller;

import com.project.my_collections.service.comment.CommentServise;
import com.project.my_collections.service.transfer.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    CommentServise commentServise;

    @MessageMapping("/send/comment")
    @SendTo("/comments")
    public CommentDTO getMessages(CommentDTO commentDTO) {
        return commentDTO;
    }
}
