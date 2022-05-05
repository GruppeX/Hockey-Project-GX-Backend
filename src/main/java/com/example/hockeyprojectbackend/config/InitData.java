package com.example.hockeyprojectbackend.config;

import com.example.hockeyprojectbackend.repository.PlayerRepository;
import com.example.hockeyprojectbackend.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
  
  
  
  
  
  

  @Autowired PlayerRepository playerRepository;

  @Autowired PositionRepository positionRepository;

  @Override
  public void run(String... args) throws Exception {
    /*Position position = new Position();
    Player player = new Player();
    position.setPlayer(player);
    position.setPositionName("Ab");
    player.setFirstName("Ab");
    player.setLastName("Ab");
    player.setPosition(position);
    player.setRole("ab");
    positionRepository.save(position);
    playerRepository.save(player);
    System.out.println("Inde i init data");*/
  }
}
