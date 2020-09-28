package com.project.my_collections.service.collection;

import com.project.my_collections.model.MyCollection;
import com.project.my_collections.repository.CollectionRepository;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.CollectionDTO;
import com.project.my_collections.service.transfer.mapper.CollectionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        MyCollection collection = collectionMapper.toEntity(collectionDTO);
        collection = collectionRepository.save(collection);
        logger.debug("Save collection: " + collection);
        return collectionMapper.toDTO(collection);
    }

    @Override
    public void updateCollection(CollectionDTO collectionDTO) {
        MyCollection collection = collectionMapper.toEntity(collectionDTO);
        logger.debug("Update collection: " + collection);
        collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(long id) {
        logger.debug("Delete collection by id: " + id);
        collectionRepository.deleteById(id);
    }

    @Override
    public CollectionDTO getCollection(long id) {
        MyCollection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Collection with id: " + id + " doesn't exist"));
        logger.debug("Get collection: " + collection);
        return collectionMapper.toDTO(collection);
    }

    @Override
    public List<CollectionDTO> getAllCollectionsForUser(long userId) {
        List<MyCollection> collections = collectionRepository.getAllCollectionsForUser(userId)
                .orElseThrow(() -> new RecordNotFoundException("Collections don't exist for user id: " + userId));
        return collectionMapper.toDTO(collections);
    }

    @Override
    public List<CollectionDTO> getBiggestCollection() {
        Pageable sortedByCollectionSize =
                PageRequest.of(0, 10, Sort.by("items").descending());

        Page<MyCollection> collections = Optional.of(collectionRepository.findAll(sortedByCollectionSize))
                .orElseThrow(() -> new RecordNotFoundException("Collections don't exist"));
        logger.debug("Biggest 10 collections: "+collections.getContent());
        return collectionMapper.toDTO(collections.getContent());
    }
}
