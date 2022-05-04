package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Admin;
import com.example.hockeyprojectbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * AdminController class
 *
 * @RestController ...
 * @CrossOrigin ...
 * @auth Vitaliy
 */

@RestController
@CrossOrigin
public class AdminControllerImpl implements AdminController {

  @Autowired
   static AdminRepository adminRepository;

  /**
   * Get a list of all admins in the system
   *
   * @return list of admins
   */
  @GetMapping("/admins")
  public  List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  /**
   * Create an admin, get a request body in json. send data to database and save the admin
   * object in database.
   *
   * @param admin data containing admin object
   * @return Entity
   */
  @PostMapping("/create/admin")
  @ResponseStatus(HttpStatus.CREATED)
    public Admin postAdmin(@RequestBody Admin admin) {
    return adminRepository.save(admin);
  }

  /**
   * Update an admin, by id of the admin that needs update, and update with new request-body.
   *
   * @param id adminId
   * @param admin admin object with updated information
   * @return a Entity with complete msg
   */
  @PutMapping("/update/admin/{id}")
  public ResponseEntity<Admin> updateAdmin(
      @PathVariable int id, @RequestBody Admin admin) {
    admin.setAdminId(id);
    Optional<Admin> optionalAdmin = adminRepository.findById(id);
    if (optionalAdmin.isPresent()) {
      adminRepository.save(admin);
      return new ResponseEntity<>(admin, HttpStatus.OK);
    } else {
      Admin notFound = new Admin();
      notFound.setUsername("Not found by id: " + id);
      return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Delete an admin find by id, delete from database
   *
   * @param id adminId
   * @return Entity msg if delete or not delete
   */

  @DeleteMapping("/delete/admin/{id}")
  public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
    try {
      adminRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }
}