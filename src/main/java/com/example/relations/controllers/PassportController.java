package com.example.relations.controllers;

import com.example.relations.DTO.PassportDTO;
import com.example.relations.services.PassportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passport")
@Tag(name = "PASSPORT API", description = "CRUD операции для паспорта")
public class PassportController {

    private final PassportService passportService;

    @Operation(summary = "Find passport", tags = {"Passport"}, description = "Find all passport for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport found successful")
    })
    @GetMapping
    public ResponseEntity<List<PassportDTO>> getPassport() {
        return ResponseEntity.ok().body(passportService.getAll());
    }

    @Operation(summary = "Find passport by id", tags = {"Passport"}, description = "Find passport by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was created successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<PassportDTO> getPassportById(@PathVariable Long id) {
        return ResponseEntity.ok().body(passportService.findById(id));
    }

    @Operation(summary = "Create passport", tags = {"Passport"}, description = "Created new passport for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was created successful")})
    @PostMapping
    public ResponseEntity<PassportDTO> createPassport(@RequestBody PassportDTO passportDTO) {
        return ResponseEntity.ok().body(passportService.create(passportDTO));
    }

    @Operation(summary = "Update passport", tags = {"Passport"}, description = "Update passport by id", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was created successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")})
    @PutMapping("/{id}")
    public ResponseEntity<PassportDTO> updatePassport(@PathVariable Long id, @RequestBody PassportDTO passportDTO) {
        return ResponseEntity.ok().body(passportService.update(id, passportDTO));

    }

    @Operation(summary = "Delete passport", tags = {"Passport"}, description = "Delete passport by id", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was created successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<PassportDTO> deletePassport(@PathVariable Long id) {
        passportService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
