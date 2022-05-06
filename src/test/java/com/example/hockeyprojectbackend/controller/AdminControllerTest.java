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
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vitaliy
 */
@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class AdminControllerTest {

  @Autowired private AdminRepository adminRepository;
  @Autowired private AdminControllerImpl adminController;


  @BeforeTestMethod
  public void beforeTest() {
    adminRepository.deleteAll();
  }

  /** Test to create an admin */
  @Test
  public void createAdminTest() {
    Admin admin = new Admin();
    admin.setAdminId(1);
    admin.setUsername("admin100");
    admin.setPassword("password100");

    adminController.postAdmin(admin);

    Optional<Admin> optionalAdmin = adminRepository.findById(1);
    assertThat(optionalAdmin.isPresent()).isTrue();
  }

}
