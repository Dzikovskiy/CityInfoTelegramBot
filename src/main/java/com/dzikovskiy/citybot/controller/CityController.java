package com.dzikovskiy.citybot.controller;

import com.dzikovskiy.citybot.entity.City;
import com.dzikovskiy.citybot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/city")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable long id) {
        return cityRepository.findById(id);
    }

    @PostMapping("/city")
    public void addCity(@RequestBody City city) {
        cityRepository.save(city);
    }

    @PutMapping("/city/{id}")
    public void editCity(@PathVariable long id, @RequestBody City city) {
        City cityDb = cityRepository.findById(id);

        cityDb.setName(city.getName());
        cityDb.setCitySights(city.getCitySights());

        cityRepository.save(cityDb);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCityById(@PathVariable long id) {
        cityRepository.deleteById(id);
    }

}

