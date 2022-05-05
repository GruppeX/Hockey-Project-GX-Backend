package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AdminController interface
 *
 * @author Vitaliy
 */

public interface AdminController {


  /**
   * Create an admin, get a request body in json. send data to database and save the admin
   * object in database.
   *
   * @param admin data containing admin object
   * @return Entity
   */
  @PostMapping("/create/admin")
  @ResponseStatus(HttpStatus.CREATED)
  Admin postAdmin(@RequestBody Admin admin);



  /**
   * Get a list of all admins in the system
   *
   * @return list of admins
   */
  @GetMapping("/admins")
  List<Admin> getAllAdmins();


  /**
   * Update an admin, by id of the admin that needs update, and update with new request-body.
   *
   * @param id adminId
   * @param admin admin object with updated information
   * @return a Entity with complete msg
   */
  @PutMapping("/update/admin/{id}")
  ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin);


  /**
   * Delete an admin find by id, delete from database
   *
   * @param id adminId
   * @return Entity msg if delete or not delete
   */

  @DeleteMapping("/delete/admin/{id}")
  ResponseEntity<String> deleteAdmin(@PathVariable int id);

}