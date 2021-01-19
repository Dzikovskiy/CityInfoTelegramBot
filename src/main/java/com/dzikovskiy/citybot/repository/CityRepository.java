package com.dzikovskiy.citybot.repository;

import com.dzikovskiy.citybot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    City findById(long id);

    void deleteById(long id);
}