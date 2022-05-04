package com.example.hockeyprojectbackend.model;

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
   * @auth Christoffer
   */
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
