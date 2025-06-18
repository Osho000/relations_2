package com.example.relations.services.Impl;

import com.example.relations.DTO.AccountDTO;
import com.example.relations.entity.Account;
import com.example.relations.repositories.AccountRepository;
import com.example.relations.services.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceimpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = new Account();
        account.setTitle(accountDTO.title());
        Account savedAccount = accountRepository.save(account);
        return new AccountDTO(savedAccount.getTitle());
    }

    @Override
    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found"));

        return new AccountDTO(account.getTitle());
    }

    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll().stream()
                .map(account -> new AccountDTO(account.getTitle()))
                .toList();
    }

    @Override
    public AccountDTO update(Long id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Account not found"));
        existingAccount.setTitle(accountDTO.title());
        Account updatedAccount = accountRepository.save(existingAccount);
        return new AccountDTO(updatedAccount.getTitle());
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
