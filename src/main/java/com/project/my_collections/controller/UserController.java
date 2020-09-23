package com.project.my_collections.controller;

import com.project.my_collections.service.transfer.dto.UserDTO;
import com.project.my_collections.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable long id) {
        logger.info("Get user id: " + id);
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/registration")
    ResponseEntity saveUser(@Valid @RequestBody UserDTO userDTO) {

        logger.info("Save new user: " + userDTO);

        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @PutMapping("/users")
    ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {

        userService.update(userDTO);

        UserDTO user = userService.findUserById(userDTO.getId());
        logger.info("Updated user: " + user);

        return ResponseEntity.ok(user);
    }
}
