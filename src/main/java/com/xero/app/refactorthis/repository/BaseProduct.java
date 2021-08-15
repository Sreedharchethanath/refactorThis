package com.xero.app.refactorthis.repository;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@MappedSuperclass
@Data
public abstract class BaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//, generator = "PRODUCT_ID_SEQ")
    //@SequenceGenerator(name="PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 100)
    private BigInteger id;
}
