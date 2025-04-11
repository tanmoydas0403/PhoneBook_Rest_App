package com.ashokit.dto;

import lombok.Data;

@Data
public class PhoneBookDto {

    private String name;
    private Long mobile;
    private String email;
    private String state;
    private String city;
    private String zipcode;
}
