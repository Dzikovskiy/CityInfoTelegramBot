package com.dzikovskiy.cityBot.Controller;

import com.dzikovskiy.cityBot.Entities.City;
import com.dzikovskiy.cityBot.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    public CityRepository cityRepository;

    @GetMapping("/cities")
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
    public City editCity(@PathVariable long id, @RequestBody City city) {
        City cityDb = cityRepository.findById(id);
        if (city.getName() != null) {
            cityDb.setName(city.getName());
        }
        if (city.getCitySights() != null) {
            cityDb.setCitySights(city.getCitySights());
        }
        cityRepository.save(cityDb);

        return cityDb;
    }

    @DeleteMapping("/city/{id}")
    public void deleteCityById(@PathVariable long id) {
        cityRepository.deleteById(id);
    }

}

