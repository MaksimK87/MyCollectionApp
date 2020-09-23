package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Role;
import com.project.my_collections.model.User;
import com.project.my_collections.service.transfer.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel ="spring", uses = {LikeMapper.class, CommentMapper.class, CollectionMapper.class})
public interface UserMapper {


    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);

    List<User> toEntity(List<UserDTO> userDTOs);

    List<UserDTO> toDTO(List<User> users);

    default Set<Role> getRoles(UserDTO userDTO) {

        return userDTO.getRoles();
    }
}
