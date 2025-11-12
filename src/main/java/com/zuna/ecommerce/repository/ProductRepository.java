package com.zuna.ecommerce.repository;

import com.zuna.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}
