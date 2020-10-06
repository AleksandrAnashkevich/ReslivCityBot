package com.resliv.city_bot.service.mapper;

import com.resliv.city_bot.entity.City;
import com.resliv.city_bot.service.dto.CityDto;

public class CityMapper {
    
    public static CityDto toDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setDescription(city.getDescription());
        return cityDto;
    }

    public static City toEntity(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setDescription(cityDto.getDescription());
        return city;
    }
}
