package com.ecommerce.sportscenter.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    private Integer maximumPoolSize;
    private Integer minimumIdle;
    private Integer connectionTimeout;
    private Integer idleTimeout;
    private Integer maxLifetime;

    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);

        // HikariCP 設定
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMinimumIdle(minimumIdle);
        config.setConnectionTimeout(connectionTimeout);
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);

        return new HikariDataSource(config);
    }
}
