package com.pas.drug.model;


import jakarta.persistence.*;

@Entity
@Table(name = "drugs")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Drug(){
        
    }


    public Drug(Long id, String name, String description, Double price, String supplierName, Integer totalQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplierName = supplierName;
        this.totalQuantity = totalQuantity;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    
}
