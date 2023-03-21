package com.example.cms.model.repository;

import com.example.cms.model.entity.UserPost;
import com.example.cms.model.entity.UserPostKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, UserPostKey> {

    @Query(value = "select * from UserPost u " +
            "where lower(u.Team) like lower(concat('%', :searchTerm, '%')) " , nativeQuery = true)
    List<UserPost> findPostByTeam(@Param("searchTerm") String searchTerm);
    
    
    @Query(value = "select * from UserPost u " +
            "where lower(u.Player) like lower(concat('%', :searchTerm, '%')) " , nativeQuery = true)
    List<UserPost> findPostByPlayer(@Param("searchTerm") String searchTerm);
    
    
    @Query(value = "select * from UserPost u " +
            "where lower(u.username) like lower(concat('%', :searchTerm, '%')) " , nativeQuery = true)
    List<UserPost> findPostByUser(@Param("searchTerm") String searchTerm);
     
}
