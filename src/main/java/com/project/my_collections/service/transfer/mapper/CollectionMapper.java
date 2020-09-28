package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.MyCollection;
import com.project.my_collections.service.transfer.dto.CollectionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, UserMapper.class})
public interface CollectionMapper {

    @Mappings({@Mapping(target = "userId", source = "user.id")})
    CollectionDTO toDTO(MyCollection collection);

    @InheritInverseConfiguration
    MyCollection toEntity(CollectionDTO collectionDTO);

    List<CollectionDTO> toDTO(List<MyCollection> collections);

    List<MyCollection> toEntity(List<CollectionDTO> collectionDTOS);
}
