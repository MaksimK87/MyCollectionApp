package com.project.my_collections.service.comment;

import com.project.my_collections.service.transfer.dto.CommentDTO;

import java.util.List;

public interface CommentServise {

    List<CommentDTO> getComments(long itemId);

    CommentDTO addComment(CommentDTO commentDTO, long itemId,long userId);
}
