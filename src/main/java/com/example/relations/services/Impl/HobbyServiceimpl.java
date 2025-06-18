package com.example.relations.services.Impl;

import com.example.relations.DTO.HobbyDTO;
import com.example.relations.entity.Hobby;
import com.example.relations.repositories.HobbyRepository;
import com.example.relations.services.HobbyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class HobbyServiceimpl implements HobbyService {
    private final HobbyRepository hobbyRepository;
    @Override
    public HobbyDTO create(HobbyDTO hobbyDTO) {
        Hobby hobby = Hobby.builder()
                .type(hobbyDTO.type())
                .build();
        Hobby savedHobby = hobbyRepository.save(hobby);
        return HobbyDTO.builder().type(savedHobby.getType()).build();

    }

    @Override
    public HobbyDTO findById(Long id) {
        Hobby hobby = hobbyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hobby not found"));
        return HobbyDTO.builder().type(hobby.getType()).build();
    }

    @Override
    public List<HobbyDTO> getAll() {
        return hobbyRepository.findAll().stream()
                .map(hobby -> HobbyDTO.builder().type(hobby.getType()).build()).toList();
    }

    @Override
    public HobbyDTO update(Long id, HobbyDTO hobbyDTO) {
        Hobby existingHobby = hobbyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Hobby not found"));
        existingHobby.setType(hobbyDTO.type());
        Hobby updatedHobby = hobbyRepository.save(existingHobby);
        return HobbyDTO.builder().type(updatedHobby.getType()).build();
    }

    @Override
    public void delete(Long id) {
        hobbyRepository.deleteById(id);
    }
}
