package com.habitjournal.habitjournalapi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HabitRequestDto {
    @NotBlank(message = "El nombre del hábito no puede estar vacio")
    private String name;

    private List<LocalDateTime> logs;
}
