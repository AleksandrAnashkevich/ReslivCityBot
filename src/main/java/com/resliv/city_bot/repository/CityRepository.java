package com.resliv.city_bot.repository;

import com.resliv.city_bot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository <City, Long> {
}
