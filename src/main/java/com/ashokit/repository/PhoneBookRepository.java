package com.ashokit.repository;

import com.ashokit.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {
}