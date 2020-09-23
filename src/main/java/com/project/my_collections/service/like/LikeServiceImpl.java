package com.project.my_collections.service.like;

import com.project.my_collections.model.Like;
import com.project.my_collections.repository.LikeRepository;
import com.project.my_collections.service.exceptions.RecordNotFoundException;
import com.project.my_collections.service.transfer.dto.LikeDTO;
import com.project.my_collections.service.transfer.mapper.LikeMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    private static final Logger logger = LogManager.getLogger(LikeServiceImpl.class);

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public void addLike(long idItem, long idUser) {
        LikeDTO likeDTO = new LikeDTO(idItem, idUser);
        if (likeRepository.findByItemIdAndUserId(idItem, idUser) == null) {
            likeRepository.save(likeMapper.toEntity(likeDTO));
        }
    }

    @Override
    public int getLikesForItem(long itemId) {
        List<Like> likes = Optional.of(likeRepository.findbyItemId(itemId)).orElseThrow(() ->
                new RecordNotFoundException("There aren't likes for item id: " + itemId));
        logger.debug("For item id: " + itemId + " likes quantity: " + likes.size());
        return likes.size();
    }
}
