package com.example.relations.services;

import com.example.relations.DTO.HobbyDTO;

import java.util.List;

public interface HobbyService {
    HobbyDTO create(HobbyDTO hobby);
    HobbyDTO findById(Long id);
    List<HobbyDTO> getAll();
    HobbyDTO update(Long id, HobbyDTO hobby);
    void delete(Long id);
}
