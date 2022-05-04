package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Admin;
import com.example.hockeyprojectbackend.repository.AdminRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * AdminController class
 *
 * @RestController ...
 * @CrossOrigin ...
 * @auth Vitaliy
 */

public interface AdminController {

  List<Admin> getAllAdmins();

  Admin postAdmin(Admin admin);

  ResponseEntity<Admin> updateAdmin(int id, Admin admin);

  ResponseEntity<String> deleteAdmin(int id);

}
