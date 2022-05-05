package com.example.hockeyprojectbackend.repository;

import com.example.hockeyprojectbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * It contains two repository PagingAndSortingRepository and CrudRepository and takes two parameters
 * We use the player object and Integer for sorting
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {}
