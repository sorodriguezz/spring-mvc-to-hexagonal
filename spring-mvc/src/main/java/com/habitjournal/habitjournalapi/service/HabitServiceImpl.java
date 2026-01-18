package com.habitjournal.habitjournalapi.service;

import com.habitjournal.habitjournalapi.controller.dto.HabitRequestDto;
import com.habitjournal.habitjournalapi.controller.dto.HabitResponseDto;
import com.habitjournal.habitjournalapi.model.Habit;
import com.habitjournal.habitjournalapi.model.LogEntry;
import com.habitjournal.habitjournalapi.repository.HabitRepository;
import com.habitjournal.habitjournalapi.service.exceptions.DuplicateHabitException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {
    private final HabitRepository habitRepository;

    @Override
    @Transactional
    public HabitResponseDto createNewHabit(HabitRequestDto requestDto) {

        habitRepository.findByName(requestDto.getName()).ifPresent(habit -> {
            throw new DuplicateHabitException(requestDto.getName());
        });

        Habit newHabit = new Habit();
        newHabit.setName(requestDto.getName());

        if (requestDto.getLogs() != null && !requestDto.getLogs().isEmpty()) {
            for (LocalDateTime date : requestDto.getLogs()) {
                LogEntry log = new LogEntry();
                log.setEntryDate(date);

                newHabit.getLogEntries().add(log);
            }
        }

        Habit habit = habitRepository.save(newHabit);

        return mapToResponseDTO(habit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HabitResponseDto> findAllHabits() {
        List<Habit> habits = habitRepository.findAll();

        return habits
                .stream().map(this::mapToResponseDTO).toList();
    }

    @Override
    public List<HabitResponseDto> findHabitsLoggedSince(int days) {
        LocalDateTime sinceDate = LocalDateTime.now().minusDays(days);
        List<Habit> activeHabits = habitRepository.findHabitsLoggedSince(sinceDate);

        return activeHabits.stream().map(this::mapToResponseDTO).toList();
    }

    private HabitResponseDto mapToResponseDTO(Habit habit) {
        List<LocalDateTime> logDates = habit
                .getLogEntries()
                .stream()
                .map(LogEntry::getEntryDate)
                .toList();

        return new HabitResponseDto(habit.getId(), habit.getName(), logDates);
    }
}
