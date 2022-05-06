package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Position;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface PositionController {

  /**
   * Creates a position in the database. When done, it returns a HTTP response 200 (OK) Mapping is
   * /create/position
   *
   * @param position - given position to create.
   * @return A HTTP response
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @PostMapping("/create/position")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> createPosition(@RequestBody Position position);

  /**
   * Get a list of positions from the database. The mapping is /show/positions
   *
   * @return A list of positions
   * @author Jackie, Christoffer, Jens and Vitaliy
   */
  @GetMapping("/show/positions")
  public List<Position> getAllPositions();

}
