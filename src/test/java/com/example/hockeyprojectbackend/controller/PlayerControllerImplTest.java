package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import com.example.hockeyprojectbackend.repository.PositionRepository;
import org.hibernate.UnsupportedLockAttemptException;
import org.hibernate.hql.internal.ast.tree.ExpectedTypeAwareNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
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

    List<Player> players = playerControllerImpl.getAllPlayers();

    assertTrue(players.size() != 0);

  }


  @Test
  void updatePlayer() {
    int playerId = 1;
    Player oldPlayer = playerRepository.findById(playerId).get();
    oldPlayer.setFirstName("Joe");

    ResponseEntity<String> playerUpdate =
        playerControllerImpl.updatePlayer(playerId, oldPlayer);
    Player playerUpdated = playerRepository.findById(playerId).get();

    assertEquals(oldPlayer.getFirstName(), playerUpdated.getFirstName());
    assertEquals(playerUpdate.getStatusCode(), HttpStatus.OK);

    //Skal denne kunne skrives om til original eller lige meget???

    // For at få orginal titlen tilbage igen efter testen
//    Activity activityRestore = activityRepository.findById(activityId).get();
//    activityRestore.setActivityTitle("goCart");
//    Activity activityUpdate1 = activityRepository.save(activityRestore);
//    org.assertj.core.api.Assertions.assertThat(activityUpdate1.getActivityTitle()).isEqualTo("goCart");
  }

  @Test
  void deletePlayer() {
  }
}