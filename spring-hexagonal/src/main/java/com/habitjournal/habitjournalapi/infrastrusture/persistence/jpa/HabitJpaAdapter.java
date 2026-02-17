package com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa;

import com.habitjournal.habitjournalapi.domain.Habit;
import com.habitjournal.habitjournalapi.domain.ports.out.HabitRepositoryPort;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.entity.HabitEntity;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.repository.HabitJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HabitJpaAdapter implements HabitRepositoryPort {
    private final HabitJpaRepository habitJpaRepository;
    private final HabitJpaMapper mapper;

    @Override
    public Habit save(Habit habit) {
        HabitEntity habitEntity = mapper.toEntity(habit);
        HabitEntity savedEntity = habitJpaRepository.save(habitEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Habit> findByName(String name) {
        return habitJpaRepository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public List<Habit> findAll() {
        return habitJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<Habit> findById(String id) {
        return habitJpaRepository.findById(id).map(mapper::toDomain);
    }
}
