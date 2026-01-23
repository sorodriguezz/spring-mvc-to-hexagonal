package com.habitjournal.habitjournalapi.domain.ports.in;

import com.habitjournal.habitjournalapi.domain.Habit;

import java.util.List;

public interface RetrieveHabitsUseCase {
    List<Habit> getHabits();
    Habit getHabit(Long id);
}
