package com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class HabitReponseDTO {
    private String id;
    private String name;
    private List<LocalDateTime> logs;
}
