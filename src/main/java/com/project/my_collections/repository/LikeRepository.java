package com.project.my_collections.repository;

import com.project.my_collections.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    @Query("select l from Like l where l.item.id = :id")
    List<Like> findbyItemId(@Param("id") long itemId);

    @Query("select l from Like l where l.item.id = :itemId and l.user.id=:userId")
    Like findByItemIdAndUserId(@Param("itemId") long itemId,@Param("userId") long userId);
}
