package com.resliv.city_bot.controller;

import com.resliv.city_bot.exception.CityAlreadyExists;
import com.resliv.city_bot.exception.CityNotFoundException;
import com.resliv.city_bot.service.CityService;
import com.resliv.city_bot.service.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRestController {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public List<CityDto> findAll() {
        return cityService.getAll();
    }

    @GetMapping("{id}")
    public CityDto findById(@PathVariable Long id) throws CityNotFoundException {
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public CityDto addCity(@RequestBody CityDto cityDto) throws CityNotFoundException, CityAlreadyExists {
        return cityService.add(cityDto);
    }

    @PutMapping("/update")
    public CityDto updateCity(@RequestBody CityDto cityDto) throws CityNotFoundException, CityAlreadyExists {
        return cityService.update(cityDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCity(@PathVariable Long id) throws CityNotFoundException {
        cityService.delete(id);
    }
}
