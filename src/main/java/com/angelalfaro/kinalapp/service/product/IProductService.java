package com.angelalfaro.kinalapp.service.product;

import com.angelalfaro.kinalapp.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService{

    /*
    * This method will return all products
     */
    List<Product> listAllProducts();

    /*
    * This method will return all products with the given state
    * */
    List<Product> listAllByState(int state);

    /*
    * This method will save a Product in the DB
    * */
    Product saveProduct(Product product);

    /*
    * Method that return a product if was finded
    * if not return a message
    * */
    Optional<Product> findByCodeProduct(Long codeProduct);

    /*
    * Method that update a Product
    * */
    Product updateProduct(Long codeProduct, Product product);

    /*
    * Method that delete an existant Product in the DB
    * */
    void deleteProduct(Long codeProduct);

    /*
    * return true if Product exists in the DB
    * */
    boolean existsByCodeProduct(Long codeProduct);

}
