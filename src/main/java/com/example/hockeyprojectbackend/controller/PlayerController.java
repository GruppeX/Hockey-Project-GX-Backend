package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @auth All
 * Interface class
 *
 * @RestController - combination of @Controller @ResponseBody
 * @CrossOrigin - enables cross-origin resource sharing only for this file specific class or method.
 */

@RestController
@CrossOrigin
public interface PlayerController {


    /**
     * Creates players to our project
     *
     * @PostMapping - is used to handle POST type of request method, etc.
     * @ResponseStatus - if it returns successfully, Spring provides a HTTP 200 (OK) response.
     * If it returns unsuccessfully it will send an exception.
     * @RequestBody - HttpRequest body onto a Java object.
     * Spring automatically deserializes the JSON into a Java type (player object), assuming an appropriate one is specified.
     */

    @PostMapping("/create/player")
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player);

    /**
     * @GetMapping - when we get something from our project/ database
     */

    @GetMapping("/show/players")
    public List<Player> getAllPlayers();

    /**
     * @PutMapping - method is used to update the resource and @PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable - would be an endpoint that identifies an entity with a primary key {id}.
     * @RequestBody - HttpRequest body onto a Java object.
     */
    @PutMapping("/update/player/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player player);

    /**
     * @DeleteMapping - when we delete something from our project/ database
     * @PathVariable - would be an endpoint that identifies an entity with a primary key {id}.
     */

    @DeleteMapping("/delete/player/{id}")
    public Player deletePlayer(@PathVariable int id);


}
