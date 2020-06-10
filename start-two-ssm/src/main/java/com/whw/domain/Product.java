package com.whw.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Product implements Serializable {
    private int product_id;
    private String name;
    private String keywords;
    private Timestamp add_time;
    private String picture;
    private String big_picture;
    private int fixed_price;
    private int lower_price;
    private String description;
    private String author;
    private String publishing;
    private Timestamp publish_time;
    private String isbn;
    private String language;
    private String which_edtion;
    private String total_page;
    private String bind_layout;
    private String book_size;
    private String editor_description;
    private String catalog;
    private String book_summary;
    private String author_summary;
    private String extracts;
    private Timestamp print_time;
    private int print_INT;
    private String paper_type;
    private String print_frequency;
}
