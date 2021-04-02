package co.com.library.service.configuration;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.jdbc.JdbcOperationsDependsOnPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
@ConditionalOnProperty(prefix = "spring.flyway", name = "enabled", matchIfMissing = true)
public class FlywayAutoConfiguration {

  @Bean(initMethod = "migrate")
  public Flyway flyway(DataSource dataSource) {
    Flyway flyway = new Flyway();
    flyway.setBaselineOnMigrate(true);
    flyway.setDataSource(dataSource);
    return flyway;
  }

  @Bean
  public FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
    return new FlywayMigrationInitializer(flyway, null);
  }

  @Configuration
  @ConditionalOnClass(JdbcOperations.class)
  @ConditionalOnBean(JdbcOperations.class)
  protected static class FlywayInitializerJdbcOperationsDependencyConfiguration
      extends JdbcOperationsDependsOnPostProcessor {

    public FlywayInitializerJdbcOperationsDependencyConfiguration() {
      super("flywayInitializer");
    }
  }
}
