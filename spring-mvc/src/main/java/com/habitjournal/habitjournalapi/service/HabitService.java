package com.habitjournal.habitjournalapi.service;

import com.habitjournal.habitjournalapi.controller.dto.HabitRequestDto;
import com.habitjournal.habitjournalapi.controller.dto.HabitResponseDto;

import java.util.List;

public interface HabitService {
    HabitResponseDto createNewHabit(HabitRequestDto requestDto);
    List<HabitResponseDto> findAllHabits();
    List<HabitResponseDto> findHabitsLoggedSince(int days);
}
