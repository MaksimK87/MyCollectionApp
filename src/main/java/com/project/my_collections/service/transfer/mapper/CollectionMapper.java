package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Collection;
import com.project.my_collections.service.transfer.dto.CollectionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, UserMapper.class})
public interface CollectionMapper {

    @Mappings({@Mapping(target = "userId", source = "user.id")})
    CollectionDTO toDTO(Collection collection);

    @InheritInverseConfiguration
    Collection toEntity(CollectionDTO collectionDTO);

    List<CollectionDTO> toDTO(List<Collection> collections);

    List<Collection> toEntity(List<CollectionDTO> collectionDTOS);
}
