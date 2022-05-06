package com.example.hockeyprojectbackend.repository;

import com.example.hockeyprojectbackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findByUsername(String username);

}
