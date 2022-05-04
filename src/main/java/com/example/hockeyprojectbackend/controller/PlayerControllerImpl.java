package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Player;
import com.example.hockeyprojectbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PlayerControllerImpl implements PlayerController {

    @Autowired
    PlayerRepository playerRepository;


    /**
     * Create a player
     *
     * @param player - Given player to create.
     * @return A HTTP response
     * @author Jackie and Christoffer
     */
    @Override
    public ResponseEntity<String> createPlayer(Player player) {
        try {
            playerRepository.save(player);
        } catch (Exception e) { //TODO: fix exception to custom
            return new ResponseEntity<>("Player not created\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Player created", HttpStatus.OK);
    }

    /**
     * Get a list of players
     *
     * @return A list of players
     * @author Jackie and Christoffer
     */
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Update a player, by id
     *
     * @param id     - Player id
     * @param player - Updated player in JSON
     * @return A HTTP response
     * @author Jackie and Christoffer
     */
    @Override
    public ResponseEntity<String> updatePlayer(int id, Player player) {
        player.setPlayerId(id); //Make sure it's the same id on the given player and the id
        Optional<Player> updatedPlayer = playerRepository.findById(id);
        try {
            if (updatedPlayer.isPresent()) {
                playerRepository.save(player);
            } else {
                return new ResponseEntity<>("Player not Updated", HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) { //TODO: fix exception to custom
            return new ResponseEntity<>("Player not Updated\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Player Updated", HttpStatus.OK);
    }

    /**
     * Delete a player
     *
     * @param id    - player id
     * @return A HTTP response
     * @author Jackie and Christoffer
     */
    @Override
    public ResponseEntity<String> deletePlayer(int id) {
        try {
            playerRepository.deleteById(id);
            return new ResponseEntity<>("Deleted id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Could not find id: " + id + "\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
