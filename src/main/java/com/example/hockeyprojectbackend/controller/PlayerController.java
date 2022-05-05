package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface class for players Hold CRUD, for players
 *
 * @author Jackie, Christoffer, Jens and Vitaliy
 */
public interface PlayerController {

  /**
   * Bonus note for annotations Creates players to our project @PostMapping - is used to handle POST
   * type of request method, etc. @ResponseStatus - if it returns successfully, Spring provides a
   * HTTP 200 (OK) response. If it returns unsuccessfully it will send an exception. @RequestBody -
   * HttpRequest body onto a Java object. Spring automatically deserializes the JSON into a Java
   * type (player object), assuming an appropriate one is specified.
   */

  /**
   * Create a player in the database. When done it returns a HTTP response 200 (OK) Mapping is
   * /create/player
   *
   * @param player - given player to create.
   * @return A HTTP response
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @PostMapping("/create/player")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> createPlayer(@RequestBody Player player);

  /** Bonus note for annotations @GetMapping - when we get something from our project/ database */

  /**
   * Get a list of players from the database. The mapping is /show/players
   *
   * @return A list of players
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @GetMapping("/show/players")
  public List<Player> getAllPlayers();

  /**
   * Bonus note for annotations @PutMapping - method is used to update the resource and @PutMapping
   * annotation for mapping HTTP PUT requests onto specific handler methods. @PathVariable - would
   * be an endpoint that identifies an entity with a primary key {id}. @RequestBody - HttpRequest
   * body onto a Java object.
   */

  /**
   * update a player from the database from given id The mapping is /show/players
   *
   * @param id - player id
   * @param player - updated player in JSON
   * @return A HTTP response
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @PutMapping("/update/player/{id}")
  public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestBody Player player);

  /**
   * Bonus note for annotations @DeleteMapping - when we delete something from our project/
   * database @PathVariable - would be an endpoint that identifies an entity with a primary key
   * {id}.
   */

  /**
   * Delete an activity found by id, delete from database
   *
   * @param id - player id
   * @return A HTTP response
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @DeleteMapping("/delete/player/{id}")
  public ResponseEntity<String> deletePlayer(@PathVariable int id);
}
