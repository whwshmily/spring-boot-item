package com.whw.domain;

import lombok.Data;

@Data
public class Address {
    private int address_id;
    private int user_id;
    private String name;
    private String provinced;
    private String address;
    private String phone;
    private String tell_phone;
    private String code;
    private String email;
}
