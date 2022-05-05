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
 * AdminController interface implementation
 *
 * @author Vitaliy
 */

@RestController
@CrossOrigin
public class AdminControllerImpl implements AdminController {

  @Autowired
  AdminRepository adminRepository;


  @Override
  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }


  @Override
  public Admin postAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  @Override
  public ResponseEntity<Admin> updateAdmin(int id, Admin admin) {
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

  @Override
  public ResponseEntity<String> deleteAdmin(int id) {
    try {
      adminRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }
}