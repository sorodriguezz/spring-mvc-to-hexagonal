package com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo;

import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.LogEntry;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo.document.HabitDocument;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo.document.LogEntryDocument;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HabitMongoMapper {
    public HabitDocument toDocument(Habit domain) {
        HabitDocument entity = new HabitDocument();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        if (domain.getLogEntries() != null) {
            List<LogEntryDocument> logs = domain.getLogEntries().stream().map(log -> {
                LogEntryDocument logDocument = new LogEntryDocument();
                logDocument.setEntryDate(log.getEntryDate());
                logDocument.setHabit(entity);
                return logDocument;
            }).collect(Collectors.toList());
            entity.setLogEntries(logs);
        }

        return entity;
    }

    public Habit toDomain(HabitDocument entity) {
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
