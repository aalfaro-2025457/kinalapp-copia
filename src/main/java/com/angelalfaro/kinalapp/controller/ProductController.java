package com.angelalfaro.kinalapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelalfaro.kinalapp.entity.Product;
import com.angelalfaro.kinalapp.service.product.ProductServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.listAllProducts();

        return ResponseEntity.ok(products);
    }

    //Get all the products by the state
    //Example.
    //if a user is banned state = 6
    //if a user is inactive state = 3 ...
    //etc
    @GetMapping("/state/{state}")
    public ResponseEntity<List<Product>> getAllProductsByState(@PathVariable(name = "state") int state) {

        List<Product> productsState = productService.listAllByState(state);

        return ResponseEntity.ok(productsState);
    }

    @GetMapping("/{codeProduct}")
    public ResponseEntity<Product> getProductByCode(@PathVariable(name = "codeProduct") Long codeProduct) {
        return productService.findByCodeProduct(codeProduct)
                //If Optional has a value, return status 200 ok with the product
                // :: call a method of a class
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        
        try {

            Product p = productService.saveProduct(product);

            return new ResponseEntity<>(p, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{codeProduct}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "codeProduct") Long codeProduct) {
        try {

            if (!productService.existsByCodeProduct(codeProduct)){
                return ResponseEntity.notFound().build();
            }

            productService.deleteProduct(codeProduct);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codeProduct}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "codeProduct") Long codeProduct,
            @RequestBody Product product) {
                
        try {
            if (!productService.existsByCodeProduct(codeProduct)){
                return ResponseEntity.notFound().build();
            }

            Product updProduct = productService.updateProduct(codeProduct,product);

            return ResponseEntity.ok(updProduct);


        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
