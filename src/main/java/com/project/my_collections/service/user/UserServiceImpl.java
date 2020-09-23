package com.project.my_collections.service.user;

import com.project.my_collections.model.Role;
import com.project.my_collections.model.User;
import com.project.my_collections.repository.UserRepository;
import com.project.my_collections.service.exceptions.PasswordMisMatchException;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.exceptions.SuchUserExistsException;
import com.project.my_collections.service.transfer.dto.UserDTO;
import com.project.my_collections.service.transfer.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO findUserById(Long userId) {
        UserDTO userDTO;
        Optional<User> userFromDb = userRepository.findById(userId);
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            logger.debug("find user: " + user);
            userDTO = userMapper.userToUserDTO(user);
            userDTO.setPasswordConfirm(userDTO.getPassword());
            return userDTO;
        } else {
            throw new RecordNotFoundException("User with id: {" + userId + "} does't exist");
        }
    }

    @Override
    public List<UserDTO> allUsers() {
        List<User> users = Optional.of(userRepository.findAll())
                .orElseThrow(() -> new RecordNotFoundException("Users don't exist"));
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User u : users) {
            userDTOs.add(userMapper.userToUserDTO(u));
        }
        return userDTOs;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        User userFromDB;
        User user;

        if (!(userDTO.getPassword().equals(userDTO.getPasswordConfirm()))) {
            throw new PasswordMisMatchException("password mismatch, check entered password");
        }

        userFromDB = userRepository.findByEmail(userDTO.getEmail());

        if (userFromDB != null) {
            throw new SuchUserExistsException("User with such email: " + userDTO.getEmail() + " exists!");
        }

        user = userMapper.userDTOtoUser(userDTO);

        logger.info("user from dtoUser: " + user);

        logger.debug("user's role: " + user.getRoles());

        if (user.getRoles() != null && user.getRoles().contains(new Role(2L, "ROLE_ADMIN"))) {

            logger.debug("Save new admin: " + user);

        } else {

            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            logger.debug("Save new user: " + user);

        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return userMapper.userToUserDTO(user);

    }

    @Override
    public boolean deleteUser(Long userId) {

        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public void update(UserDTO userDTO) {

        User user;

        if (!(userDTO.getPassword().equals(userDTO.getPasswordConfirm()))) {
            throw new PasswordMisMatchException("password mismatch, check entered password");
        }

        user = userMapper.userDTOtoUser(userDTO);

        logger.info("user from dtoUser: " + user);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
