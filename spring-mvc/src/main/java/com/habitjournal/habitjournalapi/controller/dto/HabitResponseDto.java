package com.habitjournal.habitjournalapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class HabitResponseDto {
    private String id;
    private String name;
    private List<LocalDateTime> logs;
}
