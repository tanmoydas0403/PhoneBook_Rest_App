package com.ashokit.service;

import com.ashokit.dto.PhoneBookDto;
import com.ashokit.entity.PhoneBook;
import com.ashokit.repository.PhoneBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {

    @Autowired
    private PhoneBookRepository repository;

    public void save(PhoneBookDto dto) {
        PhoneBook pb=new PhoneBook();
        BeanUtils.copyProperties(dto,pb);
        repository.save(pb);
    }
}
