package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Position;
import com.example.hockeyprojectbackend.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PositionControllerImpl implements PositionController {

  @Autowired
  PositionRepository positionRepository;

  /**
   * Create a position
   *
   * @param position - Given position to create.
   * @return A HTTP response
   * @author Christoffer
   */
  @Override
  public ResponseEntity<String> createPosition(Position position) {
    try {
      positionRepository.save(position);
    } catch (Exception e) { // TODO: fix exception to custom
      return new ResponseEntity<>("Player not created\nError: " + e, HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>("Player created", HttpStatus.OK);
  }

  /**
   * Get a list of positions
   *
   * @return A list of positions
   * @author Christoffer
   */
  @Override
  public List<Position> getAllPositions() {
    return positionRepository.findAll();
  }
}
