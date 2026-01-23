package com.habitjournal.habitjournalapi.application.exceptions;

public class HabitNotFoundException extends RuntimeException {
    public HabitNotFoundException(Long id) {
        super("No se encontró el habito con el ID: " + id);
    }
}
