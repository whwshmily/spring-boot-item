package com.whw.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Category implements Serializable {
    private int category_id;
    private String name;
    private int turn;
    private String description;
    private int parent_id;
    private List<Product> products;
}
