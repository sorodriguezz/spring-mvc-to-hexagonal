package com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HabitRequestDTO {
    @NotBlank(message = "El nombre del habito no puede estar vacio.")
    private String name;
}
