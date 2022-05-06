package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Admin;
import com.example.hockeyprojectbackend.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

/**
 * @author Vitaliy
 */
@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class AdminControllerTest {

  @Autowired private AdminRepository adminRepository;

  /** Test to create an admin */
  @Test
  public void createAdminTest() {
    Admin admin = new Admin();
    admin.setAdminId(100);
    admin.setUsername("admin100");
    admin.setPassword("password100");
    adminRepository.save(admin);

    Optional<Admin> optionalAdmin = adminRepository.findById(100);
    Assertions.assertNotNull(optionalAdmin);
  }

  /** Test to se if there are any admins exists */
  @Test
  public void testAreThereAnyAdmins() {
    List<Admin> admins = adminRepository.findAll();
    Assertions.assertNotNull(admins);
  }
}
