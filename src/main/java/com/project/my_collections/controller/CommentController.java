package com.project.my_collections.controller;

import com.project.my_collections.service.comment.CommentServise;
import com.project.my_collections.service.transfer.dto.CommentDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final Logger logger = LogManager.getLogger(CommentController.class);

    @Autowired
    private CommentServise commentServise;

    @GetMapping("/{itemId}")
    ResponseEntity<List<CommentDTO>> getAllComment(@PathVariable long itemId) {
        logger.info("Get all comments for item id: " + itemId);
        return ResponseEntity.ok(commentServise.getComments(itemId));
    }
}
