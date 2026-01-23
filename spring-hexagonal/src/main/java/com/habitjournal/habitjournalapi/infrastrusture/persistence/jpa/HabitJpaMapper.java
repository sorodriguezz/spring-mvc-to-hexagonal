package com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa;

import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.LogEntry;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.entity.HabitEntity;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.entity.LogEntryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HabitJpaMapper {
    public HabitEntity toEntity(Habit domain) {
        HabitEntity entity = new HabitEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        if (domain.getLogEntries() != null) {
            List<LogEntryEntity> logs = domain.getLogEntries().stream().map(log -> {
                LogEntryEntity logEntity = new LogEntryEntity();
                logEntity.setEntryDate(log.getEntryDate());
                logEntity.setHabit(entity);
                return logEntity;
            }).collect(Collectors.toList());
            entity.setLogEntries(logs);
        }

        return entity;
    }

    public Habit toDomain(HabitEntity entity) {
        Habit domain = new Habit();
        domain.setId(entity.getId());
        domain.setName(entity.getName());

        if (entity.getLogEntries() != null) {
            List<LogEntry> logs = entity.getLogEntries().stream().map(logEntity -> {
                LogEntry log = new LogEntry();
                log.setEntryDate(logEntity.getEntryDate());
                return log;
            }).collect(Collectors.toList());
            domain.setLogEntries(logs);
        }

        return domain;
    }
}
