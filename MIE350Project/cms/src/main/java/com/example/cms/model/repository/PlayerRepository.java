package com.example.cms.model.repository;

import com.example.cms.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
     @Query(value = "select * from Player p " +
            "where lower(p.Player) like lower(concat('%', :searchTerm, '%')) " , nativeQuery = true)
     List<Player> findPlayerByName(@Param("searchTerm") String searchTerm);
}
