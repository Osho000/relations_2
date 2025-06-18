package com.example.relations.controllers;


import com.example.relations.DTO.UserDTO;
import com.example.relations.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User API", description = "CRUD операции для пользователя")
public class UserController {

    private final UserService UserService;
    @Operation(summary = "Find User", tags = {"User"}, description = "Find all User for users", responses = {
            @ApiResponse(responseCode = "200", description = "User found successful")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser() {
        return ResponseEntity.ok().body(UserService.getAll());
    }

    @Operation(summary = "Find User by id", tags = {"User"}, description = "Find User by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(UserService.findById(id));
    }

    @Operation(summary = "Create User", tags = {"User"}, description = "Created new User for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successful")})
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO UserDTO) {
        return ResponseEntity.ok().body(UserService.create(UserDTO));
    }

    @Operation(summary = "Update User", tags = {"User"}, description = "Update User by id", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successful"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO UserDTO) {
        return ResponseEntity.ok().body(UserService.update(id, UserDTO));

    }

    @Operation(summary = "Delete User", tags = {"User"}, description = "Delete User by id", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        UserService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
