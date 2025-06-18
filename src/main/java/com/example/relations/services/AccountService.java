package com.example.relations.services;

import com.example.relations.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO create(AccountDTO accountDTO);
    AccountDTO findById(Long id);
    List<AccountDTO> getAll();
    AccountDTO update(Long id, AccountDTO accountDTO);
    void delete(Long id);
}
