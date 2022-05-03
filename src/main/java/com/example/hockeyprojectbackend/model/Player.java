package com.example.hockeyprojectbackend.model;

import javax.persistence.*;

@Entity
public class Player {    //Christoffer 12:00

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
