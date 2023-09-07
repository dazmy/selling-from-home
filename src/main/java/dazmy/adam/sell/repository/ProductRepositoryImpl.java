package dazmy.adam.sell.repository;

import com.zaxxer.hikari.HikariDataSource;
import dazmy.adam.sell.entity.Category;
import dazmy.adam.sell.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final HikariDataSource hikariDataSource;

    public ProductRepositoryImpl(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try (Connection connection = hikariDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer price = resultSet.getInt("price");
                Category category = Category.valueOf(resultSet.getString("category"));
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                Product product = new Product(id, name, price, category, createdAt, updatedAt);

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO products(name, price, category) VALUES(?, ?, ?)";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product get(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Integer price = resultSet.getInt("price");
                    Category category = Category.valueOf(resultSet.getString("category"));
                    Timestamp createdAt = resultSet.getTimestamp("created_at");
                    Timestamp updatedAt = resultSet.getTimestamp("updated_at");

                    return new Product(id, name, price, category, createdAt, updatedAt);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product get(String name) {
        String sql = "SELECT * FROM products WHERE name = ?";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Integer price = resultSet.getInt("price");
                    Category category = Category.valueOf(resultSet.getString("category"));
                    Timestamp createdAt = resultSet.getTimestamp("created_at");
                    Timestamp updatedAt = resultSet.getTimestamp("updated_at");

                    return new Product(id, name, price, category, createdAt, updatedAt);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateName(int id, String newName) {
        if (this.get(id) == null) {
            return false;
        }

        String sql = "UPDATE products SET name = ? WHERE id = ?";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updatePrice(int id, Integer newPrice) {
        if (this.get(id) == null) {
            return false;
        }

        String sql = "UPDATE products SET price = ? WHERE id = ?";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newPrice);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateCategory(int id, Category newCategory) {
        if (this.get(id) == null) {
            return false;
        }

        String sql = "UPDATE products SET category = ? WHERE id = ?";
        try (Connection connection = hikariDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newCategory.toString());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
