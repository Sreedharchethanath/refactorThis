package com.xero.app.refactorthis.mapstruct.mappers;

import com.xero.app.refactorthis.mapstruct.dtos.ProductDto;
import com.xero.app.refactorthis.mapstruct.dtos.ProductOptionsDto;
import com.xero.app.refactorthis.repository.Product;
import com.xero.app.refactorthis.repository.ProductOptions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    //@Mapping(source = "BaseProduct.getId", target = "id")
    ProductDto productToProductDto(final Product product);

    Product productDtoToProduct(final ProductDto product);

    ProductOptionsDto productOptionsToProductOptionsDto(final ProductOptions product);

    ProductOptions productOptionsDtoToProductOptions(final ProductOptionsDto product);
}
