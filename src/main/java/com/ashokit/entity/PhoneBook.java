package com.ashokit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 125)
    private String name;

    @Column(nullable = false,length=11,unique = true)
    private Long mobile;

    @Column(nullable = false)
    private String email;

    private String state;
    private String city;
    private String zipcode;
}
