package com.project.my_collections.service.tag;

import com.project.my_collections.model.Tag;
import com.project.my_collections.repository.TagRepository;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.TagDTO;
import com.project.my_collections.service.transfer.mapper.TagMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class TagServiceImpl implements TagServise {

    private static final Logger logger = LogManager.getLogger(TagServiceImpl.class);

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Set<TagDTO> getAllTags() {

        List<Tag> tags = Optional.of(tagRepository.findAll())
                .orElseThrow(() -> new RecordNotFoundException("Tags don't exist"));

        Set<Tag> tagSet = new HashSet<>();
        tags.forEach(tag -> tagSet.add(tag));
        logger.debug("Get all tags: " + tagSet);
        return tagMapper.toTagDTO(tagSet);
    }

    @Override
    public void addTag(TagDTO tagDTO) {
        tagRepository.save(tagMapper.toTagEntity(tagDTO));
    }

    @Override
    public TagDTO getById(long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Tag with id: " + id + " doesn't exist"));
        return tagMapper.toTagDTO(tag);
    }
}
