package com.xero.app.refactorthis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductsRepository extends CrudRepository<Product, BigInteger> {


}
