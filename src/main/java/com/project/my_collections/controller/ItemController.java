package com.project.my_collections.controller;

import com.project.my_collections.service.item.ItemService;
import com.project.my_collections.service.transfer.dto.ItemDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/collection")
public class ItemController {

    private static final Logger logger = LogManager.getLogger(CollectionController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping("/items/{itemId}")
    ResponseEntity<ItemDTO> getItemFromCollection(@PathVariable long itemId) {

        logger.info("Get item by id: " + itemId);
        return ResponseEntity.ok(itemService.getItem(itemId));
    }

    @GetMapping("/{collectionId}/items")
    ResponseEntity<List<ItemDTO>> getAllItemFromCollection(@PathVariable long collectionId) {
        logger.info("Get all items for collection id: " + collectionId);

        return ResponseEntity.ok(itemService.getAllItemsForCollection(collectionId));
    }

    @PostMapping("{collectionId}/items")
    ResponseEntity<ItemDTO> addItemToCollection(@Valid @RequestBody ItemDTO itemDTO,
                                                @PathVariable long collectionId) {

        logger.info("Add new item: " + itemDTO + "in collection with id: " + collectionId);
        return ResponseEntity.ok(itemService.saveItem(itemDTO, collectionId));
    }

    @PutMapping("/items/item")
    ResponseEntity updateItemInCollection(@Valid @RequestBody ItemDTO itemDTO) {

        logger.info("update item: " + itemDTO);
        itemService.updateItem(itemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/items/{itemId}")
    ResponseEntity deleteCollectionForUser(@PathVariable long itemId) {

        logger.info("Delete item by id: " + itemId);
        itemService.deleteItem(itemId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
