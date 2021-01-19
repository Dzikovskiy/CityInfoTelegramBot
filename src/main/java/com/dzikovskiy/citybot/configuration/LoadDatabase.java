package com.dzikovskiy.citybot.configuration;

import com.dzikovskiy.citybot.entity.City;
import com.dzikovskiy.citybot.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CityRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new City("Минск", "Посетите верхний город")));
            log.info("Preloading " + repository.save(new City("Москва", "Посетите красную площадь")));
        };
    }
}
