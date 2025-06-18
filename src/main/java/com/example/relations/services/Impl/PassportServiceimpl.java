package com.example.relations.services.Impl;

import com.example.relations.DTO.PassportDTO;
import com.example.relations.entity.Passport;
import com.example.relations.repositories.AccountRepository;
import com.example.relations.repositories.PassportRepository;
import com.example.relations.services.PassportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PassportServiceimpl implements PassportService {

    private final PassportRepository passportRepository;
    private final AccountRepository accountRepository;
    @Override
    public PassportDTO create(PassportDTO passportDTO) {
        Passport passport = new Passport();
        passport.setNumber(passportDTO.number());
        Passport savedPassport = passportRepository.save(passport);
        return new PassportDTO(savedPassport.getNumber());
    }

    @Override
    public PassportDTO findById(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Passport not found"));
        return new PassportDTO(passport.getNumber());
    }

    @Override
    public List<PassportDTO> getAll() {
        return passportRepository.findAll().stream()
                .map(passport -> new PassportDTO(passport.getNumber()))
                .toList();
    }

    @Override
    public PassportDTO update(Long id, PassportDTO passportDTO) {
        Passport existingPassport = passportRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Passport not found"));
        existingPassport.setNumber(passportDTO.number());
        Passport updatedPassport = passportRepository.save(existingPassport);
        return new PassportDTO(updatedPassport.getNumber());
    }

    @Override
    public void delete(Long id) {
        passportRepository.deleteById(id);
    }
}
