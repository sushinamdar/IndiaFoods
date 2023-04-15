package com.store.indiafoods.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    private String p_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" , referencedColumnName = "category_id")
    private Categories categories;

    private double p_price;

    private double p_weight;

    private String p_description;

    private String p_imageName;

}
