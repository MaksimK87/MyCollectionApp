package com.project.my_collections.service.like;

public interface LikeService {

    void addLike(long idItem, long idUser);

    int getLikesForItem(long item);

}
