package dazmy.adam.sell.repository;

import dazmy.adam.sell.entity.Product;

import java.util.List;

public interface ProductRepository {
    /**
     * Show all products
     * @return List<Product>
     */
    List<Product> getAll();

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
}
