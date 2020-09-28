package com.project.my_collections.service.comment;

import com.project.my_collections.model.Comment;
import com.project.my_collections.repository.CommentRepository;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.CommentDTO;
import com.project.my_collections.service.transfer.mapper.CommentMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentServise {

    private static final Logger logger = LogManager.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> getComments(long itemId) {
        List<Comment> comments = commentRepository.getAllComments(itemId)
                .orElseThrow(() -> new RecordNotFoundException("Comments for item with id: " + itemId + " don't exist"));
        return commentMapper.toDTO(comments);
    }

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        LocalDateTime publicationDate = LocalDateTime.now();
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setPublicationDate(publicationDate);
        comment = commentRepository.save(comment);
        logger.debug("Save comment " + comment);
        return commentMapper.toDTO(comment);
    }
}
