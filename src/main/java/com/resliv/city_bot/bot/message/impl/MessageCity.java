package com.resliv.city_bot.bot.message.impl;

import com.resliv.city_bot.bot.message.Message;
import com.resliv.city_bot.service.CityService;
import com.resliv.city_bot.service.dto.CityDto;
import com.resliv.city_bot.util.ConstantMessage;

public class MessageCity implements Message {

    private final String city;
    private final CityService cityService;


    public MessageCity(String city, CityService cityService) {
        this.city = city;
        this.cityService = cityService;
    }


    @Override
    public String send() {
        try {
            CityDto cityDto = cityService.getByName(city);
            return cityDto.getDescription();
        } catch (Exception e) {
            return ConstantMessage.EXCEPTION_MESSAGE;
        }
    }
}
