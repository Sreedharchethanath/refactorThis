package com.xero.app.refactorthis.repository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductsRepositoryTest {
    @Autowired
    ProductsRepository productsRepository;

    @Test
    public void testSaveProducts() {
        Product products = new Product("MacPro", "M1 chip", new BigDecimal(1200.00), new BigDecimal(2.00),true);
        Product result = productsRepository.save(products);
        assertEquals(true, result.getIsNew());
    }

    @Test
    public void testFindAllProducts() {
        List<Product> products = (List<Product>) productsRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    public void testFindByProductId() {
        Optional<Product> product = productsRepository.findById(new BigInteger("1"));
        assertEquals("MacBook Pro", product.get().getProductName());
        assertEquals("M1 Model Macbook", product.get().getDescription());
        assertEquals("1500.00", product.get().getPrice().toString());
        assertEquals("5.00", product.get().getDeliveryPrice().toString());
        assertEquals(true, product.get().getIsNew());
    }

}
