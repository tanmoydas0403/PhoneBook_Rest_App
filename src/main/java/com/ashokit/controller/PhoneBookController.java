package com.ashokit.controller;

import com.ashokit.dto.PhoneBookDto;
import com.ashokit.entity.PhoneBook;
import com.ashokit.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Matches the context-path in application.yml
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @PostMapping("/save")
    public ResponseEntity<PhoneBook> save(@RequestBody PhoneBookDto dto) {
        PhoneBook save = phoneBookService.save(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }
}