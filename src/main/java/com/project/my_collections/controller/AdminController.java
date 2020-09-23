package com.project.my_collections.controller;

import com.project.my_collections.model.Role;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.UserDTO;
import com.project.my_collections.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class AdminController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    ResponseEntity<List<UserDTO>> getAllUsers() {
        logger.info("Get all users");
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping("/admin/users")
    ResponseEntity<UserDTO> saveAdmin(@Valid @RequestBody UserDTO userDTO) {
        userDTO.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        logger.info("Save new admin: " + userDTO);
        UserDTO user = userService.saveUser(userDTO);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(userDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/admin/users")
    ResponseEntity<UserDTO> updateAdmin(@RequestBody UserDTO userDTO) {

        if (userDTO.getRoles().contains(new Role(2L, "ROLE_ADMIN"))) {
            userService.update(userDTO);
            UserDTO user = userService.findUserById(userDTO.getId());
            logger.info("Updated user: " + user);

            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/admin/users/{id}")
    ResponseEntity assignAdmin(@PathVariable Long id) {

        UserDTO userDTO = userService.findUserById(id);

        if (userDTO.getRoles().contains(new Role(2L, "ROLE_ADMIN"))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        userDTO.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        userService.update(userDTO);
        logger.info("Assigned user with admin rights : " + userDTO);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/admin/users/access/{id}")
    ResponseEntity<UserDTO> blockAndUnblockUser(@PathVariable Long id) {

        UserDTO userDTO = userService.findUserById(id);

        if (!(userDTO.isBlocked())) {
            userDTO.setBlocked(true);
            logger.info("Block user: " + userDTO);
        } else {
            userDTO.setBlocked(false);
            logger.info("Unblock user: " + userDTO);
        }
        userService.update(userDTO);
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);

    }

    @GetMapping("/admin/users/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        logger.info("Find user by id: " + id);
        return new ResponseEntity(userService.findUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/admin/users/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        logger.info("Delete user with id: " + id);
        if (userService.deleteUser(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        throw new RecordNotFoundException("User id: " + id + " doesn't exist");
    }

}
