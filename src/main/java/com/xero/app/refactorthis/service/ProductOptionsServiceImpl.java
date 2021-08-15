package com.xero.app.refactorthis.service;

import com.xero.app.refactorthis.repository.ProductOptionsRepository;
import com.xero.app.refactorthis.repository.ProductOptions;
import com.xero.app.refactorthis.service.exception.ResourceNotFoundException;
import com.xero.app.refactorthis.service.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProductOptionsServiceImpl implements ProductOptionsService {
    @Autowired
    ProductOptionsRepository optionsRepository;

    private static final String ERROR_MESSAGE = "Resource not found with id = ";

    public List<ProductOptions> get() {
        return (ArrayList<ProductOptions>) optionsRepository.findAll();
    }

    public List<ProductOptions> getByProductId(Long productId) {
        Optional<List<ProductOptions>> productOptions =  optionsRepository.findByProductId(productId);
        if(!productOptions.isPresent()) {
            throw new ResourceNotFoundException(ERROR_MESSAGE + productId, null);
        }
        return productOptions.get();
    }

    public ProductOptions getByIdAndProduct(Long productId, BigInteger id) {
        log.info("Retrieve ProductOptions by id {}", id);
        //Optional<ProductOptions> productOptions = optionsRepository.findById(id);

        Optional<ProductOptions> productOptions = optionsRepository.findByIdAndProductId(productId, id);
        if(!productOptions.isPresent()) {
            throw new ResourceNotFoundException(ERROR_MESSAGE + id, null);
        }
        return productOptions.get();
    }

    public ProductOptions postProductOptions(ProductOptions productOptions) {
        try {
            //productsRepository.saveAll(Arrays.asList(productOptions));
            //product.setIsNew(true);
            return optionsRepository.save(productOptions);
        } catch(Exception e) {
            log.info("Error while posting productoptions id => {} , exception => {}", productOptions.toString(), e.getStackTrace());
            throw new SystemException("ERROR_CREATION" + productOptions.toString(), null);
        }
    }

    public ProductOptions update(BigInteger id, ProductOptions productOptions) {
        try{
            ProductOptions updateableEntity = getByIdAndProduct(productOptions.getProductId(), id);

            updateableEntity.setOptionDesc(productOptions.getOptionDesc());
            updateableEntity.setProductId(productOptions.getProductId());
            updateableEntity.setOptionName(productOptions.getOptionName());

            return optionsRepository.save(updateableEntity);
        } catch(Exception e) {
            log.info("Exception while retrieving entity {} ", e.getStackTrace());
            throw new SystemException("ERROR_UPDATION" + productOptions.toString(), null);
        }
    }

    public BigInteger delete(Long productId, BigInteger id) {
        try {
            ProductOptions removableEntity = getByIdAndProduct(productId, id);
            optionsRepository.delete(removableEntity);
            return id;
        } catch(Exception e) {
            log.info("Exception while retrieving entity {} ", e.getStackTrace());
            throw new SystemException("ERROR_DELETION" + id, null);
        }
    }
}
