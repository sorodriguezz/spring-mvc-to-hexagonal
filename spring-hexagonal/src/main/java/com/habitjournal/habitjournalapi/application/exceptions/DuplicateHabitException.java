package com.habitjournal.habitjournalapi.application.exceptions;

public class DuplicateHabitException extends RuntimeException {
    public DuplicateHabitException(String name) {
        super("El habito '" + name + "' ya existe. No se permiten duplicados.");
    }
}
