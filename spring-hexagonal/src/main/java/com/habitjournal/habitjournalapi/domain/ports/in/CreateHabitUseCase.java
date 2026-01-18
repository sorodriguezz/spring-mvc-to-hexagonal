package com.habitjournal.habitjournalapi.domain.ports.in;

import com.habitjournal.habitjournalapi.domain.Habit;

public interface CreateHabitUseCase {
    Habit createHabit(Habit habit);
}
