package com.xero.app.refactorthis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductOptionsRepository extends CrudRepository<ProductOptions, BigInteger> {

    @Query("SELECT p FROM ProductOptions p where p.productId = :productId")
    public Optional<List<ProductOptions>> findByProductId(@Param("productId") Long productId);

    @Query("SELECT p FROM ProductOptions p where p.productId = :productId and p.id = :id")
    public Optional<ProductOptions> findByIdAndProductId(@Param("productId") Long productId, @Param("id") BigInteger id);


}
