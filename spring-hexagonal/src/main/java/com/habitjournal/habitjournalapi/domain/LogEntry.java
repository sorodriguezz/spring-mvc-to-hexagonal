package com.habitjournal.habitjournalapi.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private LocalDateTime entryDate;
}
