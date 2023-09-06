package dazmy.adam.sell.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTests {
    @Test
    void testConnectToMySQL() throws SQLException {
        HikariDataSource hikariDataSource = DatabaseUtil.getHikariDataSource();
        Connection connection = hikariDataSource.getConnection();

        hikariDataSource.close();
        connection.close();
    }
}
