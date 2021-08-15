package com.xero.app.refactorthis.service;

import com.xero.app.refactorthis.repository.Product;

import java.math.BigInteger;
import java.util.List;

public interface ProductsService {
    List<Product> get();
    Product getById(BigInteger id);
    Product postProduct(Product product);
    Product update(BigInteger id, Product product);
    BigInteger delete(BigInteger id);
}
