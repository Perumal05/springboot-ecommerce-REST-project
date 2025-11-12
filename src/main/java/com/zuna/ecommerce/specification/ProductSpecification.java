package com.zuna.ecommerce.specification;

import org.springframework.data.jpa.domain.Specification;
import com.zuna.ecommerce.entity.Product;


public class ProductSpecification {

    public static Specification<Product> hasCategory(String category){
        return (root, query, criteriaBuilder) -> category == null ? null : criteriaBuilder.equal(root.get("category"), category);
    }

    public static Specification<Product> hasPriceBetween(Double minPrice, Double maxPrice){
        return (root, query, criteriaBuilder) -> {
            if(minPrice == null && maxPrice == null) {
                return null;
            } else if(minPrice == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            } else if(maxPrice == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            }
        };
    }
    
    public static Specification<Product> hasKeyword(String keyword){
        return (root, query, criteriaBuilder) -> {
            if(keyword == null || keyword.isEmpty()) {
                return null;
            }
            String pattern = "%" + keyword.toLowerCase() + "%";
            return criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), pattern),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), pattern),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), pattern)
            );
        };
    }

    public static Specification<Product> hasRatings(Double ratings){
        return (root, query, criteriaBuilder) -> ratings == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("ratings"), ratings);
    }


}
