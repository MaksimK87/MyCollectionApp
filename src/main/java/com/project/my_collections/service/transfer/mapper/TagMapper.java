package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Tag;
import com.project.my_collections.service.transfer.dto.TagDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ItemMapper.class})
public interface TagMapper {

    TagDTO toTagDTO(Tag tag);

    Tag toTagEntity(TagDTO tagDTO);

    Set<TagDTO> toTagDTO(Set<Tag> tags);

    Set<Tag> toTagEntity(Set<TagDTO> tagDTOS);
}
