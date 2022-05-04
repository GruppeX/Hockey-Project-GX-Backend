package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class PlayerControllerImpl implements PlayerController {

  @Autowired
  PlayerRepository playerRepository;

  @PostMapping("/create/player") // ???? behøver man skrive annotationerne begge steder selve klassen og interface
  @ResponseStatus(HttpStatus.CREATED) // ???
  public Player createPlayer(Player player) {
    return playerRepository.save(player);
  }

  @Override
  public List<Player> getAllPlayers() {
    return null;
  }

  @Override
  public ResponseEntity<Player> updatePlayer(int id, Player player) {
    return null;
  }

  @Override
  public Player deletePlayer(int id) {
    return null;
  }
}