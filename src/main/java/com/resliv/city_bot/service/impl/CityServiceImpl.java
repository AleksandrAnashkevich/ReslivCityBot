package com.resliv.city_bot.service.impl;

import com.resliv.city_bot.repository.CityRepository;
import com.resliv.city_bot.service.CityService;
import com.resliv.city_bot.service.dto.CityDto;
import com.resliv.city_bot.service.mapper.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityDto getById(long id) {
        return null;
    }

    @Override
    public CityDto getByName(String name) {
        return null;
    }

    @Override
    public List<CityDto> getAll() {
        cityRepository.findAll().forEach(System.out::println);
        return cityRepository.findAll().stream().map(CityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CityDto create(CityDto cityDto) {
        return null;
    }

    @Override
    public CityDto update(CityDto cityDto, Long id) {
        return null;
    }

    @Override
    public void delete(CityDto cityDto) {

    }
}
