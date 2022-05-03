package com.example.hockeyprojectbackend.model;

import javax.persistence.*;

@Entity
public class Admin {


  @Id
  @Column(name = "admin_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int adminId;

  @Column(nullable = false)
  private String username;


  @Column(nullable = false)
  private String password;



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}