package co.com.library.service.configuration;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfiguration {

  @Bean
  public DataSource getConfiguration() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    try {
      dataSourceBuilder.url(
          "jdbc:mariadb://localhost:3307/training?verifyServerCertificate=false&useSSL=false&requireSSL=false&serverTimezone=GMT");
      dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
      dataSourceBuilder.username("root");
      dataSourceBuilder.password("1234");
    } catch (Exception e) {

    }
    return dataSourceBuilder.build();
  }
}
