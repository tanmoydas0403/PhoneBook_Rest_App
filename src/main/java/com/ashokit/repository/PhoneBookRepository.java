package com.ashokit.repository;

import com.ashokit.entity.PhoneBook;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {

    List<PhoneBook> findByName(String name);
    Optional<PhoneBook> findByMobile(Long mobile);
    void deleteByMobile(Long mobile);






}
