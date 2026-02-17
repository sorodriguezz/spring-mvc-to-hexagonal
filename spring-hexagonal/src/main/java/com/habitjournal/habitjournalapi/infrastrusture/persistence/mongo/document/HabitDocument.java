package com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo.document;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "habits")
public class HabitDocument {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LogEntryDocument> logEntries = new ArrayList<>();
}
