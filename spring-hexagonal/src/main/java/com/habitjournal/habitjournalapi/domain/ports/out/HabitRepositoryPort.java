package com.habitjournal.habitjournalapi.domain.ports.out;

import com.habitjournal.habitjournalapi.domain.Habit;

import java.util.Optional;

public interface HabitRepositoryPort {
    Habit save(Habit habit);
    Optional<Habit> findByName(String name);
}
