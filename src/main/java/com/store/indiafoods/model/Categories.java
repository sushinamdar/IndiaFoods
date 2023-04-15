package com.store.indiafoods.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    private String c_name;

}
