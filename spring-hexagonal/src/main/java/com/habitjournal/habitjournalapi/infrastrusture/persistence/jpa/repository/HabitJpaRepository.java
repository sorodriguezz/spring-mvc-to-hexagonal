package com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.repository;

import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabitJpaRepository extends JpaRepository<HabitEntity, String> {
    Optional<HabitEntity> findByName(String name);
}
