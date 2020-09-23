package com.project.my_collections.controller;

import com.project.my_collections.service.like.LikeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/items")
public class LikeController {

    private static final Logger logger = LogManager.getLogger(LikeController.class);

    @Autowired
    private LikeService likeService;

    @GetMapping("/{itemId}/likes")
    ResponseEntity<Integer> getLikesForItem(@PathVariable long itemId) {

        return ResponseEntity.ok(likeService.getLikesForItem(itemId));
    }

    @PostMapping("/{userId}/{itemId}/likes")
    ResponseEntity addLikeForItem(@PathVariable long userId, @PathVariable long itemId) {
        likeService.addLike(itemId,userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
