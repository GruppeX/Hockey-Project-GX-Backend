package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import com.example.hockeyprojectbackend.repository.PositionRepository;
import org.hibernate.UnsupportedLockAttemptException;
import org.hibernate.hql.internal.ast.tree.ExpectedTypeAwareNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerControllerImplTest {


  @Autowired
  PlayerRepository playerRepository;
  @Autowired
  PlayerControllerImpl playerControllerImpl;

  @Test
  void testCreatePlayerWithCorrectInfo() {
    //Arrange
    Player player = new Player();
    player.setFirstName("Hans");
    player.setLastName("Hansen");
    player.setRole("Field");
    player.setSelected(true);

    //Act
    ResponseEntity newPlayer = playerControllerImpl.createPlayer(player);

    //Assert
    assertEquals(newPlayer.getStatusCode(), HttpStatus.OK);
  }

//  @Test
//  void testCreatePlayerWithIncorrectInfo() {
//    //Arrange
//    Player player = new Player();
//    player.setFirstName(null);
//    player.setLastName("Hansen");
//    player.setRole("Field");
//    player.setSelected(true);
//
//    //Act
//    //ResponseEntity newPlayer = playerControllerImpl.createPlayer(player);
//
//    //Assert
//    assertThrowsExactly(Exception.class, ()-> {
//      playerControllerImpl.createPlayer(player);
//    });
//  }

  @Test
  void getAllPlayers() {

  }

  @Test
  void updatePlayer() {
  }

  @Test
  void deletePlayer() {
  }
}