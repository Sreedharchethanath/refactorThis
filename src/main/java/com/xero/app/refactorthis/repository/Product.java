package com.xero.app.refactorthis.repository;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
@ToString
@Builder
@Data
public class Product extends BaseProduct {

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @Column
    private Boolean isNew;

    public Product(String name, String description, BigDecimal price, BigDecimal deliveryPrice, Boolean isNew) {
        this.productName = name;
        this.description = description;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
        this.isNew = isNew;
    }

    public Product() {
    }
}
