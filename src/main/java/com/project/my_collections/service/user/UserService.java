package com.project.my_collections.service.user;

import com.project.my_collections.service.exceptions.SuchUserExistsException;
import com.project.my_collections.service.transfer.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findUserById(Long userId);

    List<UserDTO> allUsers();

    UserDTO saveUser(UserDTO userDTO) throws SuchUserExistsException;

    boolean deleteUser(Long userId);

    void update(UserDTO userDTO);
}
