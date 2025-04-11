package com.ashokit.service;

import com.ashokit.dto.PhoneBookDto;
import com.ashokit.entity.PhoneBook;
import com.ashokit.repository.PhoneBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PhoneBookService {

    private final PhoneBookRepository repository;

    @Autowired
    public PhoneBookService(PhoneBookRepository repository) {
        this.repository = repository;
    }

    public PhoneBookDto save(PhoneBookDto dto) {
        PhoneBook pb = new PhoneBook();
        BeanUtils.copyProperties(dto, pb);
        PhoneBook saved = repository.save(pb);
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    public List<PhoneBookDto> getByName(String name) {
        return repository.findByName(name).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PhoneBookDto getByMobile(Long mobile) {
        return repository.findByMobile(mobile)
                .map(this::convertToDto)
                .orElse(null);
    }

    public PhoneBookDto updateContact(Long mobile, PhoneBookDto dto) {
        return repository.findByMobile(mobile)
                .map(phoneBook -> {
                    BeanUtils.copyProperties(dto, phoneBook);
                    phoneBook.setMobile(mobile);
                    return convertToDto(repository.save(phoneBook));
                })
                .orElse(null);
    }

    @Transactional
    public Boolean delete(Long mobile) {
        return repository.findByMobile(mobile)
                .map(contact -> {
                    repository.deleteByMobile(mobile);
                    return true;
                })
                .orElse(false);
    }

    private PhoneBookDto convertToDto(PhoneBook phoneBook) {
        PhoneBookDto dto = new PhoneBookDto();
        BeanUtils.copyProperties(phoneBook, dto);
        return dto;
    }
}
