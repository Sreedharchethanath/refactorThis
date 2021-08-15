package com.xero.app.refactorthis.controller;

import com.xero.app.refactorthis.mapstruct.dtos.ProductDto;
import com.xero.app.refactorthis.mapstruct.dtos.ProductOptionsDto;
import com.xero.app.refactorthis.mapstruct.mappers.MapStructMapper;
import com.xero.app.refactorthis.service.ProductOptionsService;
import com.xero.app.refactorthis.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private MapStructMapper mapStructMapper;
    private ProductsService productService;
    private ProductOptionsService optionsService;

    @Autowired
    public ProductController(
            MapStructMapper mapStructMapper,
            ProductsService productService,
            ProductOptionsService optionsService
    ) {
        this.mapStructMapper = mapStructMapper;
        this.productService = productService;
        this.optionsService = optionsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(
            @PathVariable(value = "id") BigInteger id
    ) {
        return new ResponseEntity<ProductDto>(
                mapStructMapper.productToProductDto(
                        productService.getById(id)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<List<ProductDto>>(productService.get().stream().map(s -> mapStructMapper.productToProductDto(s)).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @PostMapping(
            path = "products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<ProductDto>(mapStructMapper.productToProductDto(productService.postProduct(mapStructMapper.productDtoToProduct(product)))
                , HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") BigInteger id, @RequestBody ProductDto product) {
        return new ResponseEntity<ProductDto>(mapStructMapper.productToProductDto(productService.update(id, mapStructMapper.productDtoToProduct(product)))
                , HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") BigInteger id) {
        return new ResponseEntity<String>("Entity Deleted" + productService.delete(id)
                , HttpStatus.OK
        );
    }

    //productOptions endpoints


    @GetMapping("/{productId}/options/{id}")
    public ResponseEntity<ProductOptionsDto> getOptionsById(
            @PathVariable(value = "productId") Long productId, @PathVariable(value = "id") BigInteger id
    ) {
        return new ResponseEntity<ProductOptionsDto>(
                mapStructMapper.productOptionsToProductOptionsDto(
                        optionsService.getByIdAndProduct(productId, id)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{productId}/options")
    public ResponseEntity<List<ProductOptionsDto>> getAllProductOptions(@PathVariable(value = "productId") Long productId) {
        return new ResponseEntity<List<ProductOptionsDto>>(optionsService.getByProductId(productId).stream().map(s -> mapStructMapper.productOptionsToProductOptionsDto(s)).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @PostMapping(
            path = "/{productId}/options",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductOptionsDto> postProductOptions(@RequestBody ProductOptionsDto product) {
        return new ResponseEntity<ProductOptionsDto>(mapStructMapper.productOptionsToProductOptionsDto(optionsService.postProductOptions(mapStructMapper.productOptionsDtoToProductOptions(product)))
                , HttpStatus.OK
        );
    }

    @PutMapping("/{productId}/options/{id}")
    public ResponseEntity<ProductOptionsDto> updateProductOptions(@PathVariable(value = "productId") Long productId, @PathVariable(value = "id") BigInteger id, @RequestBody ProductOptionsDto product) {
        return new ResponseEntity<ProductOptionsDto>(mapStructMapper.productOptionsToProductOptionsDto(optionsService.update(id, mapStructMapper.productOptionsDtoToProductOptions(product)))
                , HttpStatus.OK
        );
    }

    @DeleteMapping("/{productId}/options/{id}")
    public ResponseEntity<String> deleteProductOptions(@PathVariable(value = "productId") Long productId, @PathVariable(value = "id") BigInteger id) {
        return new ResponseEntity<String>("Entity Deleted" + optionsService.delete(productId, id)
                , HttpStatus.OK
        );
    }






}
