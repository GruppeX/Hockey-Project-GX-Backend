package com.example.hockeyprojectbackend.controller;

import com.example.hockeyprojectbackend.model.Admin;
import com.example.hockeyprojectbackend.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

  @Test
  public void updateAdminTest() {
    Admin admin = new Admin();
    admin.setAdminId(1);
    admin.setUsername("admin100");
    admin.setPassword("password100");
    adminRepository.save(admin);

    Admin newAdmin = new Admin();
    newAdmin.setAdminId(1);
    newAdmin.setUsername("admin123");
    newAdmin.setPassword("password100");

    adminController.updateAdmin(1, newAdmin);

    Optional<Admin> optionalAdmin = adminRepository.findById(1);
    assertThat(optionalAdmin.isPresent()).isTrue();

    assertEquals("admin123", optionalAdmin.get().getUsername());
  }

  @Test
  public void updateAdminWithWrongIdTest() {
    Admin admin = new Admin();
    admin.setAdminId(1);
    admin.setUsername("admin100");
    admin.setPassword("password100");
    adminRepository.save(admin);

    Admin newAdmin = new Admin();
    newAdmin.setAdminId(1);
    newAdmin.setUsername("admin123");
    newAdmin.setPassword("password100");

    adminController.updateAdmin(2, newAdmin);

    Optional<Admin> optionalAdmin = adminRepository.findById(1);
    assertThat(optionalAdmin.isPresent()).isTrue();

    assertNotEquals("admin123", optionalAdmin.get().getUsername());
  }
}
