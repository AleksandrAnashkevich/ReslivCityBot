package com.resliv.city_bot.service.impl;

import com.resliv.city_bot.entity.City;
import com.resliv.city_bot.exception.CityAlreadyExists;
import com.resliv.city_bot.exception.CityNotFoundException;
import com.resliv.city_bot.repository.CityRepository;
import com.resliv.city_bot.service.CityService;
import com.resliv.city_bot.service.dto.CityDto;
import com.resliv.city_bot.service.mapper.CityMapper;
import com.resliv.city_bot.util.ConstantExceptionMessage;
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
        City city = cityRepository.findById(id);
        if (!(city == null)) {
            return CityMapper.toDto(city);
        } else {
            throw new CityNotFoundException(ConstantExceptionMessage.cityNotFoundExceptionMessage);
        }
    }

    @Override
    public CityDto getByName(String name) {
        City city = cityRepository.findByName(name);
        if (!(city == null)) {
            return CityMapper.toDto(city);
        } else {
            throw new CityNotFoundException(ConstantExceptionMessage.cityNotFoundExceptionMessage);
        }
    }

    @Override
    public List<CityDto> getAll() {
        return cityRepository.findAll().stream().map(CityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CityDto add(CityDto cityDto) {
        if (cityRepository.existsByName(cityDto.getName())) {
            throw new CityAlreadyExists(ConstantExceptionMessage.cityAlreadyExistsMessageFirstPart
                    + cityDto.getName() + ConstantExceptionMessage.cityAlreadyExistsMessageSecondPart);
        } else {
            cityRepository.save(CityMapper.toEntity(cityDto));
        }
        return cityDto;
    }

    @Override
    public CityDto update(CityDto cityDto) {
        if (cityRepository.existsById(cityDto.getId())) {
            if (cityRepository.existsByNameIsAndIdNot(cityDto.getName(),cityDto.getId())) {
                throw new CityAlreadyExists(ConstantExceptionMessage.cityAlreadyExistsMessageFirstPart
                        + cityDto.getName() + ConstantExceptionMessage.cityAlreadyExistsMessageSecondPart);
            }
            cityRepository.save(CityMapper.toEntity(cityDto));
        } else {
            throw new CityNotFoundException(ConstantExceptionMessage.cityNotFoundExceptionMessage);
        }
        return cityDto;
    }

    @Override
    public void delete(Long id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
        } else {
            throw new CityNotFoundException(ConstantExceptionMessage.cityNotFoundExceptionMessage);
        }
    }
}
