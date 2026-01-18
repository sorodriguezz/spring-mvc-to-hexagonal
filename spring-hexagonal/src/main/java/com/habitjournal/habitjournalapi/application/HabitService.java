package com.habitjournal.habitjournalapi.application;

import com.habitjournal.habitjournalapi.application.exceptions.DuplicateHabitException;
import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.ports.in.CreateHabitUseCase;
import com.habitjournal.habitjournalapi.domain.ports.out.HabitRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HabitService implements CreateHabitUseCase {
    private final HabitRepositoryPort habitRepositoryPort;

    @Override
    public Habit createHabit(Habit habit) {

        habitRepositoryPort.findByName(habit.getName()).ifPresent(
                existing -> {
                    throw new DuplicateHabitException(habit.getName());
                }
        );

        if (!habit.hasValidName()) {
            throw new IllegalArgumentException("El nombre del habito no cumple con las reglas de negocio.");
        }

        return habitRepositoryPort.save(habit);
    }
}
