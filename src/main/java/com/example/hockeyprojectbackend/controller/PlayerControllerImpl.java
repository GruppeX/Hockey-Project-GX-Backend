package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerControllerImpl implements PlayerController {

  @Autowired
  PlayerRepository playerRepository;

  @GetMapping("/")
  public String welcome() {
    return "test";
  }


  @PostMapping("/create/player") // ???? behøver man skrive annotationerne begge steder selve klassen og interface
  @ResponseStatus(HttpStatus.CREATED) // ???
  public Player createPlayer(@RequestBody Player player) {
    return playerRepository.save(player);
  }

  @GetMapping("/get/players")
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }


  @Override
  public ResponseEntity<Player> updatePlayer(int id, Player player) {
    return null;
  }


  @DeleteMapping("/delete/player/{id}")
  public ResponseEntity<String> deletePlayer(@PathVariable int id) {
    try {
      playerRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }
}
