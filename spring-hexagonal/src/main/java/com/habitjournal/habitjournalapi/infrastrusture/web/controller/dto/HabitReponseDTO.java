package com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitReponseDTO {
    private Long id;
    private String name;
}
