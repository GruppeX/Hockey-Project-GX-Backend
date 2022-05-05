package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class PlayerControllerImplTest {

  @Autowired private PlayerRepository playerRepository;

  @BeforeEach
  public void beforeTest() {
    playerRepository.deleteAll();

    Player player = new Player();
    player.setPlayerId(1);
    player.setFirstName("Hans");
    player.setRole("GoalKeeper");
    player.setLastName("Hansen");
    player.setIsSelected(false);
    playerRepository.save(player);

    player = new Player();
    player.setPlayerId(2);
    player.setFirstName("Kurt");
    player.setRole("GoalKeeper2");
    player.setLastName("Jensen");
    player.setIsSelected(false);
    playerRepository.save(player);
  }

  @Test
  public void findAllPlayersTest() {
    // Get a list of all players
    List<Player> players = playerRepository.findAll();

    // Expected players in list (2 are made as default first)
    int expectedPlayers = 2;

    assertThat(players).hasSize(expectedPlayers);
  }

  @Test
  public void createNewPlayerTest() {
    // Create a player with id
    Player player = new Player();
    player.setPlayerId(10);
    player.setFirstName("Name");
    player.setRole("GoalKeeper");
    player.setLastName("lastName");
    player.setIsSelected(false);
    playerRepository.save(player);

    // Find player
    Optional<Player> playerById = playerRepository.findById(10);

    assertThat(playerById).isNotNull();
  }

  @Test
  public void updatePlayerNameTest() {
    //Find player by id
    Optional<Player> playerById = playerRepository.findById(1);

    //Create a player by the found player, if not exist, it's null
    Player newPlayer = playerById.orElse(null);
    if (newPlayer != null) {
      newPlayer.setFirstName("Gert");
      playerRepository.save(newPlayer);
    }

    // Is player null
    assertThat(newPlayer).isNotNull();
    // Name is correct
    assertEquals("Gert", newPlayer.getFirstName());
  }

  @Test
  public void deletePlayerByIdTest() {
    // Delete player by id 1
    playerRepository.deleteById(1);

    // Find player
    Optional<Player> findPlayer = playerRepository.findById(1);

    // If player not present it works
    assertThat(findPlayer.isPresent()).isFalse();
  }
}
