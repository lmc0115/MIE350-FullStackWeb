package com.example.cms.model.repository;

import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
  @Query(value = "select * from Team t " +
            "where lower(t.Team) like lower(concat('%', :tName, '%')) " , nativeQuery = true)
  List<Team> findByTName(@Param("tName") String tName);

}
