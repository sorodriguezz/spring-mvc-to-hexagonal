package com.habitjournal.habitjournalapi.controller;

import com.habitjournal.habitjournalapi.controller.dto.HabitRequestDto;
import com.habitjournal.habitjournalapi.controller.dto.HabitResponseDto;
import com.habitjournal.habitjournalapi.service.HabitService;
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
    private final HabitService habitService;

    @PostMapping
    public ResponseEntity<HabitResponseDto> createNewHabit(@Valid @RequestBody HabitRequestDto habitRequestDto) {
        HabitResponseDto responseDto = habitService.createNewHabit(habitRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HabitResponseDto>> findAllHabits() {
        List<HabitResponseDto> habitResponseDtos = habitService.findAllHabits();

        return ResponseEntity.ok(habitResponseDtos);
    }

    @GetMapping("/active")
    public ResponseEntity<List<HabitResponseDto>> getActiveHabits(@RequestParam(defaultValue = "7") int days) {
        List<HabitResponseDto> habitsLoggedSince = habitService.findHabitsLoggedSince(days);

        return ResponseEntity.ok(habitsLoggedSince);
    }
}
