package com.example.cms.model.repository;

import com.example.cms.model.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <WebUser, String>{
    @Query(value = "select * from WebUser where username = :searchTerm", nativeQuery = true)
    List<WebUser> searchUser(@Param("searchTerm") String searchTerm);

}
