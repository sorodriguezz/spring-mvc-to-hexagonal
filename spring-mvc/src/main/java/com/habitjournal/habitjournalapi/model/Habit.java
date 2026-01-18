package com.habitjournal.habitjournalapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "habits")
public class Habit {

    @Id
    private String id;
    private String name;

    List<LogEntry> logEntries = new ArrayList<>();
}
