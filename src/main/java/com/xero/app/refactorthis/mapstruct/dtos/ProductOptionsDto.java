package com.xero.app.refactorthis.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductOptionsDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("productName")
    private String optionName;

    @JsonProperty("description")
    private String optionDesc;

}
