package com.resliv.city_bot.exception;

public class CityAlreadyExists extends RuntimeException{

    public CityAlreadyExists(){}

    public CityAlreadyExists(String message){
        super(message);
    }
}
