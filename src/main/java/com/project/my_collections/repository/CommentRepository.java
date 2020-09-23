package com.project.my_collections.repository;

import com.project.my_collections.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.item.id = :id order by c.publicationDate asc")
    Optional<List<Comment>> getAllComments(@Param("id") long id);
}
