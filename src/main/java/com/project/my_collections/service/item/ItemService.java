package com.project.my_collections.service.item;

import com.project.my_collections.service.transfer.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO saveItem(ItemDTO itemDTO,long collectionId);

    void updateItem(ItemDTO itemDTO);

    void deleteItem(long id);

    ItemDTO getItem(long id);

    List<ItemDTO> getAllItemsForCollection(long collectionId);


}
