package com.example.grofers_app;

public class CartResponse {
    private String ImageUrl;
    private String ProductName;
    private String ProductSellingPrice;
    private String ProductMRP;
    private String ProductUnit;

    public CartResponse(String imageUrl, String productName, String productSellingPrice, String productMRP, String productUnit) {
        ImageUrl = imageUrl;
        ProductName = productName;
        ProductSellingPrice = productSellingPrice;
        ProductMRP = productMRP;
        ProductUnit = productUnit;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductSellingPrice() {
        return ProductSellingPrice;
    }

    public String getProductMRP() {
        return ProductMRP;
    }

    public String getProductUnit() {
        return ProductUnit;
    }
}
