package com.habitjournal.habitjournalapi.infrastrusture.web.controller;

import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.ports.in.CreateHabitUseCase;
import com.habitjournal.habitjournalapi.domain.ports.in.RetrieveHabitsUseCase;
import com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto.HabitReponseDTO;
import com.habitjournal.habitjournalapi.infrastrusture.web.controller.dto.HabitRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {
    private final CreateHabitUseCase createHabitUseCase;
    private final RetrieveHabitsUseCase retrieveHabitsUseCase;
    private final HabitDtoMapper habitDtoMapper;

    @PostMapping
    public ResponseEntity<HabitReponseDTO> createNewHabit(@Valid @RequestBody HabitRequestDTO requestDTO) {
        Habit domainHabit = habitDtoMapper.toDomain(requestDTO);
        Habit createdHabit = createHabitUseCase.createHabit(domainHabit);
        return ResponseEntity.status(HttpStatus.CREATED).body(habitDtoMapper.toResponse(createdHabit));
    }

    @GetMapping
    public ResponseEntity<List<HabitReponseDTO>> getAllHabits() {
        List<Habit> habits = retrieveHabitsUseCase.getHabits();
        List<HabitReponseDTO> responseDTO = habits.stream().map(habitDtoMapper::toResponse).toList();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitReponseDTO> getHabitById(@PathVariable String id) {
        Habit habit = retrieveHabitsUseCase.getHabit(id);
        return ResponseEntity.ok(habitDtoMapper.toResponse(habit));
    }
}
