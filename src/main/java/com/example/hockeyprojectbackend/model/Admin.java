package com.example.hockeyprojectbackend.model;

import javax.persistence.*;

/**
 * Admin model class from JPA
 *
 * @Entity creater tabel in mySQL
 * @auth Christoffer
 */
@Entity
public class Admin {

  /**
   * Creates autoincremented ID for our column admin_id
   *
   * @Id = PrimaryKey
   * @Column = name for specific column
   * @GeneratedValue = Autoincremented value
   * @auth Christoffer
   */
  @Id
  @Column(name = "admin_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int adminId;

  @Column(nullable = false)
  private String username;


  @Column(nullable = false)
  private String password;


  /**
   * Getter and setter for adminId parameter
   *
   * @auth Vitaliy
   */


  public int getAdminId() {
    return adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }

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