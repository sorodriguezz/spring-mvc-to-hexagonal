package com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HabitRequestDTO {
    @NotBlank(message = "El nombre del habito no puede estar vacio.")
    private String name;
    private List<LocalDateTime> logs;
}
