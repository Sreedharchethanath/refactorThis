package com.xero.app.refactorthis.service;

import com.xero.app.refactorthis.repository.Product;
import com.xero.app.refactorthis.repository.ProductsRepository;
import com.xero.app.refactorthis.service.exception.ResourceNotFoundException;
import com.xero.app.refactorthis.service.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    private static final String ERROR_MESSAGE = "Resource not found with id = ";

    public List<Product> get() {
        return (ArrayList<Product>) productsRepository.findAll();
    }

    public Product getById(BigInteger id) {
        log.info("Retrieve product by id {}", id);
        Optional<Product> product = productsRepository.findById(id);
        if(!product.isPresent()) {
            throw new ResourceNotFoundException(ERROR_MESSAGE + id, null);
        }
        return product.get();
    }

    public Product postProduct(Product product) {
        try {
            //productsRepository.saveAll(Arrays.asList(product));
            product.setIsNew(true);
            return productsRepository.save(product);
        } catch(Exception e) {
            log.info("Error while posting product id => {} , exception => {}", product.toString(), e.getStackTrace());
            throw new SystemException("ERROR_CREATION" + product.toString(), null);
        }
    }

    public Product update(BigInteger id, Product product) {
            try{
                Product updateableEntity = getById(id);
                updateableEntity.setDeliveryPrice(product.getDeliveryPrice());
                updateableEntity.setDescription(product.getDescription());
                updateableEntity.setPrice(product.getPrice());
                updateableEntity.setProductName(product.getProductName());
                updateableEntity.setIsNew(false);
                return productsRepository.save(updateableEntity);
            } catch(Exception e) {
                log.info("Exception while retrieving entity {} ", e.getStackTrace());
                throw new SystemException("ERROR_UPDATION" + product.toString(), null);
        }
    }

    public BigInteger delete(BigInteger id) {
        try {
            Product removableEntity = getById(id);
            productsRepository.delete(removableEntity);
            return id;
        } catch(Exception e) {
            log.info("Exception while retrieving entity {} ", e.getStackTrace());
            throw new SystemException("ERROR_DELETION" + id, null);
        }
    }
}
