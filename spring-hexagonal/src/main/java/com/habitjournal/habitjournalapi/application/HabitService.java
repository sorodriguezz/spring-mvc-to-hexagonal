package com.habitjournal.habitjournalapi.application;

import com.habitjournal.habitjournalapi.application.exceptions.DuplicateHabitException;
import com.habitjournal.habitjournalapi.application.exceptions.HabitNotFoundException;
import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.ports.in.CreateHabitUseCase;
import com.habitjournal.habitjournalapi.domain.ports.in.RetrieveHabitsUseCase;
import com.habitjournal.habitjournalapi.domain.ports.out.HabitRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class HabitService implements CreateHabitUseCase, RetrieveHabitsUseCase {
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

    @Override
    public List<Habit> getHabits() {
        return habitRepositoryPort.findAll();
    }

    @Override
    public Habit getHabit(Long id) {
        return habitRepositoryPort.findById(id).orElseThrow(() -> new HabitNotFoundException(id));
    }
}
