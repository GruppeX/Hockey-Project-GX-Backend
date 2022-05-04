package com.example.hockeyprojectbackend.config;

import com.example.hockeyprojectbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
