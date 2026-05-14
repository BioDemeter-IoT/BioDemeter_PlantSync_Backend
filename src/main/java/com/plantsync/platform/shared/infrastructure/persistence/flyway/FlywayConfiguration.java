package com.plantsync.platform.shared.infrastructure.persistence.flyway;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Flyway migrations.
 * Ensures Flyway repairs and migrates the database on startup.
 */
@Configuration
public class FlywayConfiguration {

  /**
   * Constructor for FlywayConfiguration.
   *
   * @param dataSource The data source to be used by Flyway.
   */
  @Autowired
  public FlywayConfiguration(DataSource dataSource) {
    Flyway flyway = Flyway.configure()
        .baselineOnMigrate(true)
        .dataSource(dataSource)
        .load();

    flyway.repair();
    flyway.migrate();
  }
}
