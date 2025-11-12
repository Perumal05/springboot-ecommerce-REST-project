package com.zuna.ecommerce.dto;

public class ProductReviewResponseDto {
    private Long id;
    private Double ratings;
    private String comments;

    public ProductReviewResponseDto() {}

    public ProductReviewResponseDto(Long id, Double ratings, String comments) {
        this.id = id;
        this.ratings = ratings;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getRatings() {
        return ratings;
    }
    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
