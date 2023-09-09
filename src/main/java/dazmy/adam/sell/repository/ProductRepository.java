package dazmy.adam.sell.repository;

import dazmy.adam.sell.entity.Category;
import dazmy.adam.sell.entity.Product;

import java.util.List;

public interface ProductRepository {
    /**
     * Show all products
     * @return List<Product>
     */
    List<Product> getAll();

    /**
     * Show all products using query where
     * @param where String
     * @param query String
     * @return List<Product>
     */
    List<Product> getWhere(String where, String query);

    /**
     * Add product into the database
     * @param product product
     */
    void add(Product product);

    /**
     * Show the product using id
     * @param id int
     * @return Product
     */
    Product get(int id);

    /**
     * Show the product using name
     * @param name String
     * @return Product
     */
    Product get(String name);

    /**
     * update product name
     * @param id int
     * @param newName String
     * @return boolean
     */
    boolean updateName(int id, String newName);

    /**
     * update product price
     * @param id int
     * @param newPrice Integer
     * @return boolean
     */
    boolean updatePrice(int id, Integer newPrice);

    /**
     * update product category
     * @param id int
     * @param newCategory Category
     * @return boolean
     */
    boolean updateCategory(int id, Category newCategory);
}
