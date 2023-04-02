package com.example.minitest2md4.model;

import javax.persistence.*;

@Entity
@Table
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paintingCode;
    private Double height;
    private Double width;
    private String material;
    private  String description;
    private Double price;
    @ ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Painting() {
    }

    public Painting(Long id, String paintingCode, Double height, Double width, String material, String description, Double price, Category category) {
        this.id = id;
        this.paintingCode = paintingCode;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaintingCode() {
        return paintingCode;
    }

    public void setPaintingCode(String paintingCode) {
        this.paintingCode = paintingCode;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
