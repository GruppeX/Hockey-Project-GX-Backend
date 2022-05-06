package com.example.hockeyprojectbackend.repository;

import com.example.hockeyprojectbackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {}
