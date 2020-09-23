package com.project.my_collections.service.collection;

import com.project.my_collections.model.Collection;
import com.project.my_collections.repository.CollectionRepository;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.CollectionDTO;
import com.project.my_collections.service.transfer.mapper.CollectionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CollectionServiceImpl implements CollectionService {

    private static final Logger logger = LogManager.getLogger(CollectionServiceImpl.class);

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public CollectionDTO saveCollection(CollectionDTO collectionDTO, long userId) {
        collectionDTO.setUserId(userId);
        Collection collection = collectionMapper.toEntity(collectionDTO);
        collection = collectionRepository.save(collection);
        logger.debug("Save collection: " + collection);
        return collectionMapper.toDTO(collection);
    }

    @Override
    public void updateCollection(CollectionDTO collectionDTO) {
        Collection collection = collectionMapper.toEntity(collectionDTO);
        logger.debug("Update collection: "+collection);
        collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(long id) {
        logger.debug("Delete collection by id: " + id);
        collectionRepository.deleteById(id);
    }

    @Override
    public CollectionDTO getCollection(long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Collection with id: " + id + " doesn't exist"));
        logger.debug("Get collection: " + collection);
        return collectionMapper.toDTO(collection);
    }

    @Override
    public List<CollectionDTO> getAllCollectionsForUser(long userId) {
        List<Collection> collections = collectionRepository.getAllCollectionsForUser(userId)
                .orElseThrow(() -> new RecordNotFoundException("Collections don't exist for user id: " + userId));
        return collectionMapper.toDTO(collections);
    }

    /*@Override
    public List<CollectionDTO> getAllCollectionsFromUser(long userId) {
        List<Collection> collections=
        return null;
    }*/

    @Override
    public List<CollectionDTO> getBiggestCollection() {
        return null;
    }
}
