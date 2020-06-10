package com.whw.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    private int cart_id;
    private  Product product;
    private int user_id;
    private int product_num;

    public boolean equals(Object obj) {
        if (obj instanceof Cart) {
            Cart c = (Cart) obj;
            return this.product.getProduct_id() == c.getProduct().getProduct_id();
        }
        return false;
    }

}
