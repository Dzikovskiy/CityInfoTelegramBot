package com.dzikovskiy.cityBot.Repository;

import com.dzikovskiy.cityBot.Entities.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    City findByName(String name);
    City findById(long id);
    List<City> findAll();
    void deleteById(long id);
}