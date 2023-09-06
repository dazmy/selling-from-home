package dazmy.adam.sell.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static final HikariDataSource hikariDataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db_selling_from_home");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        // pool
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60000);
        hikariConfig.setMaxLifetime(60 * 60000);

        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
