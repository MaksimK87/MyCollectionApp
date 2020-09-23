package com.project.my_collections.service.transfer.mapper;

import com.project.my_collections.model.Comment;
import com.project.my_collections.service.transfer.dto.CommentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, UserMapper.class})
public interface CommentMapper {
    //CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);


    @Mappings({@Mapping(source = "user.id", target = "userId"), @Mapping(source = "item.id",
            target = "itemId"), @Mapping(target = "publicationDate", source = "publicationDate", dateFormat = "HH:mm dd-MM-yyyy")})
    CommentDTO toDTO(Comment comment);

    @InheritInverseConfiguration
    Comment toEntity(CommentDTO commentDTO);

    List<Comment> toEntity(List<CommentDTO> commentDTOs);

    List<CommentDTO> toDTO(List<Comment> comments);


  /*  default String dateToString(LocalDateTime creationDate) {
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
