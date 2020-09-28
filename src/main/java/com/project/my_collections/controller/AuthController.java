package com.project.my_collections.controller;

import com.project.my_collections.config.jwt.JwtUtils;
import com.project.my_collections.config.jwt.payload.request.LoginRequest;
import com.project.my_collections.config.jwt.payload.request.SignupRequest;
import com.project.my_collections.config.jwt.payload.response.JwtResponse;
import com.project.my_collections.config.jwt.payload.response.MessageResponse;
import com.project.my_collections.model.User;
import com.project.my_collections.service.transfer.dto.UserDTO;
import com.project.my_collections.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthController {

    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        logger.info("Login: " + loginRequest.getEmail() + " Password " + loginRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        logger.info("JWT: "+jwt);

        User userDetails = (User) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getName(), userDetails.getEmail(), roles));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        logger.info("Register new user: " + signUpRequest);

        UserDTO userDTO = new UserDTO(signUpRequest.getName(), signUpRequest.getPassword(),
                signUpRequest.getPasswordConfirm(), signUpRequest.getEmail());
        userService.saveUser(userDTO);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
