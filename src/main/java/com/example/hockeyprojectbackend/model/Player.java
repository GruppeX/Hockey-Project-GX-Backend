package com.example.hockeyprojectbackend.model;

import javax.persistence.*;

/**
 * Player model class from JPA @Entity creater tabel in mySQL
 *
 * @auth Christoffer
 */
@Entity
public class Player { // Christoffer 12:00

  /**
   * Creates autoincremented ID for our column player_id @Id = PrimaryKey @Column = name for
   * specific column @GeneratedValue = Autoincremented value
   *
   * @auth Christoffer
   */
  @Id
  @Column(name = "player_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playerId;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String role;

  @Column(nullable = false)
  private boolean isSelected;

  /**
   * Joining player with position class @OneToOne makes relationship between 1 column @JoinColumn
   * Joining column of other table
   *
   * @auth Christoffer
   */
  @OneToOne
  @JoinColumn(name = "position_id")
  private Position position;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean selected) {
    isSelected = selected;
  }
}
