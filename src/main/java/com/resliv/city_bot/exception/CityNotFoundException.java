package com.resliv.city_bot.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(){}

    public CityNotFoundException(String message){
        super(message);
    }

}
