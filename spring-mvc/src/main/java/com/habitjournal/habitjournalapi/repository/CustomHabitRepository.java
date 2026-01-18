package com.habitjournal.habitjournalapi.repository;

import com.habitjournal.habitjournalapi.model.Habit;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomHabitRepository {
    List<Habit> findHabitsLoggedSince(LocalDateTime sinceDate);
}
