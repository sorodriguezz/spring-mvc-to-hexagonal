package com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.entity;

import com.habitjournal.habitjournalapi.domain.LogEntry;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "habits")
public class HabitEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LogEntryEntity> logEntries = new ArrayList<>();
}
