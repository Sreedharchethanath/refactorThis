package com.xero.app.refactorthis.repository;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_options")
@ToString
@Builder
@Data
public class ProductOptions extends BaseProduct {
    @Column
    private Long productId;

    @Column
    private String optionName;

    @Column
    private String optionDesc;

    public ProductOptions(Long productId, String optionName, String optionDesc) {
        this.productId = productId;
        this.optionName = optionName;
        this.optionDesc = optionDesc;
    }

    public ProductOptions() {

    }
}
