package com.example.relations.services;

import com.example.relations.DTO.PassportDTO;

import java.util.List;

public interface PassportService {
    PassportDTO create(PassportDTO passportDTO);
    PassportDTO findById(Long id);
    List<PassportDTO> getAll();
    PassportDTO update(Long id, PassportDTO passportDTO);
    void delete(Long id);
}
