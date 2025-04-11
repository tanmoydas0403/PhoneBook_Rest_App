package com.ashokit.controller;

import com.ashokit.dto.PhoneBookDto;
import com.ashokit.service.PhoneBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PhoneBookController {

    private final PhoneBookService phoneBookService;

    @Autowired
    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @PostMapping("/contacts")
    public ResponseEntity<PhoneBookDto> createContact(@Valid @RequestBody PhoneBookDto dto) {
        return new ResponseEntity<>(phoneBookService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/contacts")
    public ResponseEntity<?> getContactsByName(@RequestParam String name) {
        List<PhoneBookDto> contacts = phoneBookService.getByName(name);
        return contacts.isEmpty() 
            ? new ResponseEntity<>("No Contact Found",HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/contacts/{mobile}")
    public ResponseEntity<?> getContactByMobile(@PathVariable Long mobile) {
        PhoneBookDto contact = phoneBookService.getByMobile(mobile);
        return contact != null 
            ? new ResponseEntity<>(contact, HttpStatus.OK)
            : new ResponseEntity<>("No Contact Found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/contacts/{mobile}")
    public ResponseEntity<String> updateContact(
            @PathVariable Long mobile,
            @Valid @RequestBody PhoneBookDto dto) {
        PhoneBookDto updated = phoneBookService.updateContact(mobile, dto);
        return updated != null 
            ? new ResponseEntity<>("Contact Updated Successfully", HttpStatus.OK)
            : new ResponseEntity<>("Contact Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/contacts/{mobile}")
    public ResponseEntity<String> deleteContact(@PathVariable Long mobile) {
        return phoneBookService.delete(mobile)
            ? new ResponseEntity<>("Contact Delete Successfully",HttpStatus.NO_CONTENT)
            : new ResponseEntity<>("Contact Not Found",HttpStatus.NOT_FOUND);
    }
}