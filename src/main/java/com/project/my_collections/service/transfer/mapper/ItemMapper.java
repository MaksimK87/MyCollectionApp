package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Item;
import com.project.my_collections.service.transfer.dto.ItemDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring", uses = {TagMapper.class, CollectionMapper.class, LikeMapper.class, CommentMapper.class})
public interface ItemMapper {

    @Mappings({@Mapping(target = "collectionId", source = "collection.id"),
            @Mapping(target = "customDateField1", source = "customDateField1",dateFormat = "dd.MM.yyyy")})
    ItemDTO toDTO(Item item);

    //@InheritInverseConfiguration
    @Mappings({@Mapping(target = "collection.id", source = "collectionId"),
            @Mapping(target = "customDateField1", source = "customDateField1", dateFormat = "dd.MM.yyyy")})
    Item toEntity(ItemDTO itemDTO);

    List<ItemDTO> toDTO(List<Item> items);

    List<Item> toEntity(List<ItemDTO> itemDTOS);

    /*default String dateToString(LocalDateTime creationDate) {
        if (creationDate != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
            return dateTimeFormatter.format(creationDate);
        }
        return null;
    }

    default LocalDateTime stringToDate(String creationDate) {
        if (creationDate != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

            return LocalDateTime.parse(creationDate, dateTimeFormatter);
        }
        return null;

    }*/
}
