package com.project.my_collections.repository;

import com.project.my_collections.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    @Query("select c from Collection c where c.user.id = :id")
    Optional<List<Collection>> getAllCollectionsForUser(@Param("id") long id);

}
