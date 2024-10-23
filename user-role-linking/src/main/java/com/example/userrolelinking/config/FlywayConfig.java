package com.example.userrolelinking.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

  @Value("${spring.flyway.locations}")
  private String locations;

  @Value("${spring.flyway.schemas}")
  private String schemas;

  @Bean(initMethod = "migrate")
  public Flyway flyway(DataSource dataSource) {
    return Flyway.configure()
            .dataSource(dataSource)
            .locations(locations)
            .schemas(schemas)
            .load();
  }

}