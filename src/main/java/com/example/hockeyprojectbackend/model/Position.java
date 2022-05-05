package com.example.hockeyprojectbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Position model class from JPA @Entity creater tabel in mySQL
 *
 * @auth Christoffer
 */
@Entity
public class Position {

  /**
   * Creates autoincremented ID for our column position_id @Id = PrimaryKey @Column = name for
   * specific column @GeneratedValue = Autoincremented value
   *
   * @auth Christoffer
   */
  @Id
  @Column(name = "position_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int positionId;

  @Column(nullable = false)
  private String positionName;

  /**
   * Joining position with player class @OneToOne makes relationship between 1 column @JoinColumn
   * Joining column of other table
   *
   * @OneToOne makes relationship between 1 column, CascadeType on both classes so we can add a player to a position
   * and a position to a player
   * @JoinColumn Joining column of other table
   * @auth Christoffer
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "player_id")
  @JsonBackReference
  private Player player;

  public int getPositionId() {
    return positionId;
  }

  public void setPositionId(int positionId) {
    this.positionId = positionId;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}
