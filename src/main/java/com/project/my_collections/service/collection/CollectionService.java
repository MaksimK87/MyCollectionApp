package com.project.my_collections.service.collection;

import com.project.my_collections.service.transfer.dto.CollectionDTO;

import java.util.List;

public interface CollectionService {

    CollectionDTO saveCollection(CollectionDTO collectionDTO, long userId);

    void updateCollection(CollectionDTO collectionDTO);

    void deleteCollection(long id);

    CollectionDTO getCollection(long id);

    List<CollectionDTO> getAllCollectionsForUser(long userId);

    List<CollectionDTO> getBiggestCollection();


}
