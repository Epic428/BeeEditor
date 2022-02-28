package com.teamresourceful.editorbackend.config;

import com.teamresourceful.editorbackend.repository.BeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(BeeRepository repository) {
        return args -> repository.saveAll(Arrays.asList(FirstBee.generate(), SecondBee.generate()));
    }
}
