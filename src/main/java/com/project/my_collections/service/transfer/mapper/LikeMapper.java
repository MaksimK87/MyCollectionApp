package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Like;
import com.project.my_collections.service.transfer.dto.LikeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ItemMapper.class})
public interface LikeMapper {

    @Mappings({@Mapping(target = "idItem", source = "item.id"),
            @Mapping(target = "idUser", source = "user.id")})
    LikeDTO toDTO(Like like);

    @InheritInverseConfiguration
    Like toEntity(LikeDTO likeDTO);

    Set<LikeDTO> toDTO(Set<Like> likes);

    Set<Like> toEntity(Set<LikeDTO> likeDTOS);


}
