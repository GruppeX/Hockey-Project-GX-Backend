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
   * @return admin Entity
   * @ResponseStatus marks a method with the status code and reason message that should be returned
   * @RequestBody indicates a method parameter should be bind to the body of the HTTP request
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
   * @param id    adminId
   * @param admin admin object with updated information
   * @return a Entity with complete msg
   * @PathVariable used to handle template variable in the request URI mapping and set it as method parameter
   * @RequestBody indicates a method parameter should be bind to the body of the HTTP request
   */
  @PutMapping("/update/admin/{id}")
  ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin);


  /**
   * Delete an admin find by id, delete from database
   *
   * @param id adminId
   * @return Entity msg if delete or not delete
   * @PathVariable used to handle template variable in the request URI mapping and set it as method parameter
   */

  @DeleteMapping("/delete/admin/{id}")
  ResponseEntity<String> deleteAdmin(@PathVariable int id);

}