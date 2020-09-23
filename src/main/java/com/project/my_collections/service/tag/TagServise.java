package com.project.my_collections.service.tag;

import com.project.my_collections.service.transfer.dto.TagDTO;

import java.util.Set;

public interface TagServise {

    Set<TagDTO> getAllTags();

    void addTag(TagDTO tagDTO);

    TagDTO getById(long id);

}
