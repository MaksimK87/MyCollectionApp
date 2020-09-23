package com.project.my_collections.service.item;

import com.project.my_collections.model.Item;
import com.project.my_collections.repository.ItemRepository;
import com.project.my_collections.service.collection.CollectionService;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.ItemDTO;
import com.project.my_collections.service.transfer.mapper.ItemMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CollectionService collectionService;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO, long collectionId) {
        itemDTO.setCollectionId(collectionId);
        Item item = itemMapper.toEntity(itemDTO);
        item = itemRepository.save(item);
        logger.debug("Save item: " + item);
        return itemMapper.toDTO(item);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        Item item = itemMapper.toEntity(itemDTO);
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO getItem(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Item with id: " + id + " doesn't exist"));
        return itemMapper.toDTO(item);
    }

    @Override
    public List<ItemDTO> getAllItemsForCollection(long collectionId) {
        List<ItemDTO> items=Optional.of(collectionService.getCollection(collectionId)
                .getItems()).orElseThrow(() ->
                new RecordNotFoundException("Items not found for collection id: " + collectionId));
        return items;
    }
}
