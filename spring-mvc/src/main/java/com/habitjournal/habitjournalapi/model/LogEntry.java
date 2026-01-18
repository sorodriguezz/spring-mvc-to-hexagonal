package com.habitjournal.habitjournalapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private LocalDateTime entryDate;
}
