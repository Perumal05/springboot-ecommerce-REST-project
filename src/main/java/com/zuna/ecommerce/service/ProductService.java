package com.zuna.ecommerce.service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import com.zuna.ecommerce.specification.ProductSpecification;
import com.zuna.ecommerce.dto.ProductReviewDto;
import com.zuna.ecommerce.dto.ProductResponseDto;
import com.zuna.ecommerce.dto.ProductReviewResponseDto;
import com.zuna.ecommerce.dto.ProductImageDto;
import com.zuna.ecommerce.entity.Product;
import com.zuna.ecommerce.entity.ProductReview;
import com.zuna.ecommerce.repository.ProductRepository;
import com.zuna.ecommerce.repository.ProductReviewRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    /**
     * Get all products with pagination, including images and reviews.
     */
    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);

        // Convert Product entities to DTOs
        List<ProductResponseDto> products = productPage.getContent().stream()
                .map(this::mapToProductResponseDto)
                .collect(Collectors.toList());

        // Prepare response map
        Map<String, Object> response = new HashMap<>();
        response.put("products", products);
        response.put("totalProducts", productPage.getTotalElements());
        response.put("totalPages", productPage.getTotalPages());
        response.put("currentPage", productPage.getNumber());

        return response;
    }

    /**
     * Get a single product by ID.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /**
     * Search products dynamically using JPA Specifications.
     */
    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String keyword, Double ratings) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category)
                .and(ProductSpecification.hasPriceBetween(minPrice, maxPrice))
                .and(ProductSpecification.hasKeyword(keyword))
                .and(ProductSpecification.hasRatings(ratings))
        );

        return productRepository.findAll(spec);
    }

    /**
     * Add a new product review.
     */
    public void addProductReview(ProductReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductReview productReview = new ProductReview();
        productReview.setComments(reviewDto.getComments());
        productReview.setRatings(reviewDto.getRatings());
        productReview.setProduct(product);

        productReviewRepository.save(productReview);
    }

    /**
     * Helper method to map Product entity to ProductResponseDto.
     */
    private ProductResponseDto mapToProductResponseDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getRatings(),
                product.getSeller(),
                product.getStock(),
                product.getNumOfReviews(),
                product.getImages() != null ? product.getImages().stream()
                        .map(img -> new ProductImageDto(img.getUrl(), img.getPublicId()))
                        .collect(Collectors.toList()) : null,
                product.getReviews() != null ? product.getReviews().stream()
                        .map(r -> new ProductReviewResponseDto(r.getId(), r.getRatings(), r.getComments()))
                        .collect(Collectors.toList()) : null
        );
    }
}
