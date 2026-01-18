package com.habitjournal.habitjournalapi.repository;

import com.habitjournal.habitjournalapi.model.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitRepository extends MongoRepository<Habit, Long>, CustomHabitRepository {
    Optional<Habit> findByName(String name);
}
