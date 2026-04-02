package com.app.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String brand;
    private String model;
    private double cost;
    @Column(name = "purchased_on")
    private Date purchasedOn;
    @Column(name = "purchased_from")
    private String purchasedFrom;
    @Column(name = "warranty_till")
    private Date warrantyTill;
    @Embedded
    private Configurations configurations;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Configurations getConfigurations() {
        return configurations;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Date getPurchasedOn() {
        return purchasedOn;
    }
    public void setPurchasedOn(Date purchasedOn) {
        this.purchasedOn = purchasedOn;
    }
    public String getPurchasedFrom() {
        return purchasedFrom;
    }
    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }
    public Date getWarrantyTill() {
        return warrantyTill;
    }
    public void setWarrantyTill(Date warrantyTill) {
        this.warrantyTill = warrantyTill;
    }
    public void setConfigurations(Configurations configurations) {
        this.configurations = configurations;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", purchasedOn=" + purchasedOn +
                ", purchasedFrom='" + purchasedFrom + '\'' +
                ", configurations=" + configurations +
                '}';
    }
}
