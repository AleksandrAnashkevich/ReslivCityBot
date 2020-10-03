package com.resliv.city_bot.controller.handler;

import com.resliv.city_bot.exception.dto.ExceptionDto;
import com.resliv.city_bot.exception.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CityExceptionHandler {
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionDto cityNotFound(RuntimeException e) {
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionDto isException(RuntimeException e) {
        return new ExceptionDto(e.getMessage());
    }
}
