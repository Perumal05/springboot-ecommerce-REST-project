package com.zuna.ecommerce.dto;

import com.zuna.ecommerce.dto.ProductImageDto;
import com.zuna.ecommerce.dto.ProductReviewDto; 
import com.zuna.ecommerce.dto.ProductReviewResponseDto;


import java.util.List;

public class ProductResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Double ratings;
    private String seller;
    private Integer stock;
    private Integer numOfReviews;
    private List<ProductImageDto> images;
    private List<ProductReviewResponseDto> reviews;

    public ProductResponseDto() {}

    public ProductResponseDto(Long id, String name, Double price, String description,
            String category, Double ratings, String seller, Integer stock,
            Integer numOfReviews, List<ProductImageDto> images,
            List<ProductReviewResponseDto> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.numOfReviews = numOfReviews;
        this.images = images;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }

    public List<ProductImageDto> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDto> images) {
        this.images = images;
    }

    public List<ProductReviewResponseDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewResponseDto> reviews) {
        this.reviews = reviews;
    }

    // ✅ Add getters & setters below
    // (you can generate them automatically in your IDE)
}

