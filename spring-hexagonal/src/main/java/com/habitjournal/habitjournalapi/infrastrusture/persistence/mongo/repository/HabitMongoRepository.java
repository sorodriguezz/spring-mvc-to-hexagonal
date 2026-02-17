package com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo.repository;

import com.habitjournal.habitjournalapi.infrastrusture.persistence.mongo.document.HabitDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabitMongoRepository extends JpaRepository<HabitDocument, String> {
    Optional<HabitDocument> findByName(String name);
}
