package com.resliv.city_bot.service;

import com.resliv.city_bot.service.dto.CityDto;

import java.util.List;

public interface CityService {

    CityDto getById(long id);

    CityDto getByName(String name);

    List<CityDto> getAll();

    CityDto create(CityDto cityDto);

    CityDto update(CityDto cityDto, Long id);

    void delete(CityDto cityDto);
}
