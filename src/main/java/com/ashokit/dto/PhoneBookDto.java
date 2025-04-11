package com.ashokit.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PhoneBookDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 125, message = "Name must be between 2 and 125 characters")
    private String name;

    @NotNull(message = "Mobile number is required")
    @Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
    private Long mobile;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String state;
    private String city;

    @Pattern(regexp = "^\\d{6}$", message = "Zipcode must be 6 digits")
    private String zipcode;
}
