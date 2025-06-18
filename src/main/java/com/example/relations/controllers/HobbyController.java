package com.example.relations.controllers;


import com.example.relations.DTO.HobbyDTO;
import com.example.relations.services.HobbyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hobby")
@Tag(name = "Hobby API", description = "CRUD операции для хобби")
public class HobbyController {

    private final HobbyService HobbyService;
    @Operation(summary = "Find Hobby", tags = {"Hobby"}, description = "Find all Hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby found successful")
    })
    @GetMapping
    public ResponseEntity<List<HobbyDTO>> getHobby() {
        return ResponseEntity.ok().body(HobbyService.getAll());
    }

    @Operation(summary = "Find Hobby by id", tags = {"Hobby"}, description = "Find Hobby by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<HobbyDTO> getHobbyById(@PathVariable Long id) {
        return ResponseEntity.ok().body(HobbyService.findById(id));
    }

    @Operation(summary = "Create Hobby", tags = {"Hobby"}, description = "Created new Hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successful")})
    @PostMapping
    public ResponseEntity<HobbyDTO> createHobby(@RequestBody HobbyDTO HobbyDTO) {
        return ResponseEntity.ok().body(HobbyService.create(HobbyDTO));
    }

    @Operation(summary = "Update Hobby", tags = {"Hobby"}, description = "Update Hobby by id", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @PutMapping("/{id}")
    public ResponseEntity<HobbyDTO> updateHobby(@PathVariable Long id, @RequestBody HobbyDTO HobbyDTO) {
        return ResponseEntity.ok().body(HobbyService.update(id, HobbyDTO));

    }

    @Operation(summary = "Delete Hobby", tags = {"Hobby"}, description = "Delete Hobby by id", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HobbyDTO> deleteHobby(@PathVariable Long id) {
        HobbyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
