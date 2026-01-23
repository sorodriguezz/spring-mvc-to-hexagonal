package com.habitjournal.habitjournalapi.infrastrusture.config;

import com.habitjournal.habitjournalapi.application.HabitService;
import com.habitjournal.habitjournalapi.domain.ports.in.CreateHabitUseCase;
import com.habitjournal.habitjournalapi.domain.ports.out.HabitRepositoryPort;
import com.habitjournal.habitjournalapi.infrastrusture.persistence.jpa.HabitJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public HabitRepositoryPort habitRepositoryPort(HabitJpaAdapter habitJpaAdapter) {
        return habitJpaAdapter;
    }

    @Bean
    public CreateHabitUseCase createHabitUseCase(HabitRepositoryPort habitRepositoryPort) {
        return new HabitService(habitRepositoryPort);
    }

}
