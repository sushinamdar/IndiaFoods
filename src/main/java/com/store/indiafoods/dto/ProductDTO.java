package com.store.indiafoods.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long p_id;
    private String p_name;
    private int category_id;
    private double p_price;
    private double p_weight;
    private String description;
    private String imageName;
}
