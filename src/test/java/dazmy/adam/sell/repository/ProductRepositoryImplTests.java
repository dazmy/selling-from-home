package dazmy.adam.sell.repository;

import com.zaxxer.hikari.HikariDataSource;
import dazmy.adam.sell.entity.Category;
import dazmy.adam.sell.entity.Product;
import dazmy.adam.sell.util.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImplTests {
    private HikariDataSource hikariDataSource;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        hikariDataSource = DatabaseUtil.getHikariDataSource();
        productRepository = new ProductRepositoryImpl(hikariDataSource);
    }

    @AfterEach
    void tearDown() {
        hikariDataSource.close();
    }

    @Test
    void testGetAll() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        List<Product> all = productRepository.getAll();

        connection.close();

        // make sure you have at least one data
        Assertions.assertFalse(all.isEmpty());
        all.forEach(System.out::println);
    }

    @Test
    void testGetWhere() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        List<Product> products = productRepository.getWhere("category", "Food");
        connection.close();

        Assertions.assertFalse(products.isEmpty());
        products.forEach(System.out::println);
    }

    @Test
    void testGetWhereError() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            List<Product> products = productRepository.getWhere("price", "error");
        });

        connection.close();
    }

    @Test
    void testAdd() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        Product product = new Product("Ayam Goreng", 7000, Category.Food);
        productRepository.add(product);

        // check has it been entered into the database ?
        List<Product> all = productRepository.getAll();
        Product theProduct = all.get(all.size() - 1);
        Assertions.assertEquals(theProduct.getName(), product.getName());

        connection.close();
    }

    @Test
    void testGet() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        Product product1 = productRepository.get(4);
        Product product2 = productRepository.get("Ayam Goreng");

        connection.close();

        // check here
        Assertions.assertNotNull(product1);
        Assertions.assertNotNull(product2);
    }

    @Test
    void testUpdateName() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updateName(3, "Nasi Goreng");

        connection.close();

        Assertions.assertTrue(isSuccessUpdate);
    }

    @Test
    void testUpdateNameError() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updateName(3, "Mie Goreng");

        connection.close();

        Assertions.assertFalse(isSuccessUpdate);
    }

    @Test
    void testUpdatePrice() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updatePrice(6, 10000);

        connection.close();

        Assertions.assertTrue(isSuccessUpdate);
    }

    @Test
    void testUpdatePriceError() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updatePrice(1, 10000);

        connection.close();

        // can't find the ID
        Assertions.assertFalse(isSuccessUpdate);
    }

    @Test
    void testUpdateCategory() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updateCategory(3, Category.valueOf("Drink"));

        connection.close();

        Assertions.assertTrue(isSuccessUpdate);
    }

    @Test
    void testUpdateCategoryError() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        boolean isSuccessUpdate = productRepository.updateCategory(1, Category.valueOf("Other"));

        connection.close();

        // can't find the ID
        Assertions.assertFalse(isSuccessUpdate);
    }
}
