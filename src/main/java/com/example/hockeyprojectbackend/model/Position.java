package com.example.hockeyprojectbackend.model;

import javax.persistence.*;

@Entity
public class Position {


  @Id
  @Column(name = "position_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int positionId;

  @Column(nullable = false)
  private String positionName;

  @OneToOne
  @JoinColumn(name = "player_id")
  private Player player;





  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }
}
