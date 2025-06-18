package com.example.relations.controllers;


import com.example.relations.DTO.AccountDTO;
import com.example.relations.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@Tag(name = "Account API", description = "CRUD операции для аккаунта")
public class AccountController {

    private final AccountService AccountService;
    @Operation(summary = "Find Account", description = "Find all Account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account found successful")
    })
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccount() {
        return ResponseEntity.ok().body(AccountService.getAll());
    }

    @Operation(summary = "Find Account by id", description = "Find Account by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok().body(AccountService.findById(id));
    }

    @Operation(summary = "Create Account", description = "Created new Account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successful")})
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO AccountDTO) {
        return ResponseEntity.ok().body(AccountService.create(AccountDTO));
    }

    @Operation(summary = "Update Account",  description = "Update Account by id", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO AccountDTO) {
        return ResponseEntity.ok().body(AccountService.update(id, AccountDTO));

    }

    @Operation(summary = "Delete Account",  description = "Delete Account by id", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id) {
        AccountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
