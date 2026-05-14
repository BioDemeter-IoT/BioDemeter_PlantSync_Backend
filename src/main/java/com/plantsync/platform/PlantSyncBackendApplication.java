package com.plantsync.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlantSyncBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantSyncBackendApplication.class, args);
    }

}
