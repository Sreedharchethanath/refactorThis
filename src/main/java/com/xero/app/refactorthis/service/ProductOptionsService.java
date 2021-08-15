package com.xero.app.refactorthis.service;

import com.xero.app.refactorthis.repository.ProductOptions;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProductOptionsService {
    List<ProductOptions> get();
    //ProductOptions getById(BigInteger id);
    ProductOptions postProductOptions(ProductOptions options);
    ProductOptions update(BigInteger id, ProductOptions options);
    BigInteger delete(Long productId, BigInteger id);
    List<ProductOptions> getByProductId(Long productId);
    ProductOptions getByIdAndProduct(Long productId, BigInteger id);
}