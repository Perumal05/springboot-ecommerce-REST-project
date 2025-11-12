package com.zuna.ecommerce.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zuna.ecommerce.entity.Product;
import com.zuna.ecommerce.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {
            List<Product> demoproducts = List.of(
                new Product(null, "Apple iPhone 13", 999.99, "Latest model of iPhone","Phone", 4.8, "Apple", 50, List.of("products/1.jpg")),
                new Product(null, "Samsung Galaxy S21", 799.99, "Flagship Samsung smartphone","Phone", 4.6, "Samsung", 70, List.of("products/2.jpg")),
                new Product(null, "Sony WH-1000XM4", 349.99, "Noise-cancelling over-ear headphones","Headphones", 4.7, "Sony", 100, List.of("products/3.jpg")),
                new Product(null, "Dell XPS 13", 1199.99, "High-performance ultrabook laptop","Laptop", 4.5, "Dell", 30, List.of("products/4.jpg")),
                new Product(null, "Apple MacBook Pro", 1999.99, "Powerful laptop for professionals","Laptop", 4.8, "Apple", 20, List.of("products/5.jpg")),
                new Product(null, "Google Pixel 6", 699.99, "Google's latest smartphone with excellent camera","Phone", 4.4, "Google", 60, List.of("products/6.jpg")),
                new Product(null, "Bose QuietComfort Earbuds", 279.99, "True wireless noise-cancelling earbuds","Headphones", 4.5, "Bose", 80, List.of("products/7.jpg")),
                new Product(null, "HP Spectre x360", 1399.99, "Convertible 2-in-1 laptop","Laptop", 4.6, "HP", 25, List.of("products/8.jpg")),
                new Product(null, "OnePlus 9 Pro", 969.99, "High-end smartphone with fast performance","Phone", 4.5, "OnePlus", 40, List.of("products/9.jpg")),
                new Product(null, "JBL Flip 5", 119.99, "Portable Bluetooth speaker with powerful sound","Speaker", 4.4, "JBL", 150, List.of("products/10.jpg")),
                new Product(null, "Asus ROG Zephyrus G14", 1499.99, "Gaming laptop with high refresh rate display","Laptop", 4.7, "Asus", 15, List.of("products/11.jpg"))
            );
            productRepository.saveAll(demoproducts);
            System.out.println("Seeded demo products into the database.");
        }
        else {
            System.out.println("Products already exist in the database. Skipping seeding.");
        }
    }   

}
