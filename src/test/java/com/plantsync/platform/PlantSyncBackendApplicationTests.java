package com.plantsync.platform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.profiles.active=test",
        "spring.datasource.url=jdbc:h2:mem:plantsync-context-test;MODE=MySQL;DATABASE_TO_LOWER=TRUE;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
        "spring.jpa.show-sql=false",
        "spring.flyway.enabled=false",
        "weather.api.key=test-weather-key",
        "authorization.jwt.secret=WriteHereYourSecretStringForTokenSigningCredentials",
        "authorization.jwt.expiration.days=7",
        "documentation.application.description=PlantSync Backend",
        "documentation.application.version=0.0.1-SNAPSHOT"
})
class PlantSyncBackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
