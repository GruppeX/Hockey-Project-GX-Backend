package com.example.hockeyprojectbackend.repository;

import com.example.hockeyprojectbackend.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {}
