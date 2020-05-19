package com.whw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmStatusBean implements Comparable<ConfirmStatusBean> {
    private String name;
    private double value;

    public int compareTo(ConfirmStatusBean o) {
        return (int) (this.value - o.value);
    }
}
