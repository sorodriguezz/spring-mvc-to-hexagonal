package com.habitjournal.habitjournalapi.infrastrusture.web.controller;

import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.LogEntry;
import com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto.HabitReponseDTO;
import com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto.HabitRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HabitDtoMapper {
    public Habit toDomain(HabitRequestDTO dto) {
        Habit habit = new Habit();
        habit.setName(dto.getName());

        if (dto.getLogs() != null) {
            List<LogEntry> logs = dto.getLogs().stream().map(date -> {
                LogEntry log = new LogEntry();
                log.setEntryDate(date);
                return log;
            }).toList();

            habit.setLogEntries(logs);
        }

        return habit;
    }

    public HabitReponseDTO toResponse(Habit habit) {
        List<LocalDateTime> logDates = habit.getLogEntries().stream().map(LogEntry::getEntryDate).toList();
        return new HabitReponseDTO(habit.getId(), habit.getName(), logDates);
    }
}
