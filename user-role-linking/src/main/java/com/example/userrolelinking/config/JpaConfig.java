package com.example.userrolelinking.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.userrolelinking.repository")
@EntityScan(basePackages = {"com.example.userrolelinking.model", "com.example.roleservice.model", "com.example.userservice.model"})
public class JpaConfig {
  //
}

