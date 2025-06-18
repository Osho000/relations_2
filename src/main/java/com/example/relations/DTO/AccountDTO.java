package com.example.relations.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccountDTO(
        @NotNull
        @Size(min= 1, max = 50)
        String title

) {
}
