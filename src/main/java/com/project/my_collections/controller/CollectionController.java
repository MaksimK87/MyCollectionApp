package com.project.my_collections.controller;

import com.project.my_collections.service.collection.CollectionService;
import com.project.my_collections.service.transfer.dto.CollectionDTO;
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
//@RequestMapping("")
public class CollectionController {

    private static final Logger logger = LogManager.getLogger(CollectionController.class);

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/users/{userId}/collections")
    ResponseEntity<List<CollectionDTO>> getAllCollectionsForUser(@PathVariable long userId) {
        logger.info("Get all collections for user id: " + userId);
        return ResponseEntity.ok(collectionService.getAllCollectionsForUser(userId));
    }

    @GetMapping("/collections/{collectionId}")
    ResponseEntity<CollectionDTO> getCollectionForUser(@PathVariable long collectionId) {
        logger.info("Get collection id: " + collectionId);

        return ResponseEntity.ok(collectionService.getCollection(collectionId));
    }

    @PostMapping("/users/{userId}/collections")
    ResponseEntity<CollectionDTO> addCollectionForUser(@Valid @RequestBody CollectionDTO collectionDTO,
                                                       @PathVariable long userId) {

        logger.info("Add new collection: " + collectionDTO + " for user id: " + userId);
        return ResponseEntity.ok(collectionService.saveCollection(collectionDTO, userId));
    }

    @PutMapping("/users/collections")
    ResponseEntity updateCollectionForUser(@Valid @RequestBody CollectionDTO collectionDTO) {

        logger.info("update collection: " + collectionDTO);
        collectionService.updateCollection(collectionDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/collections/{collectionId}")
    ResponseEntity deleteCollectionForUser(@PathVariable long collectionId) {

        logger.info("Delete collection by id: " + collectionId);
        collectionService.deleteCollection(collectionId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
