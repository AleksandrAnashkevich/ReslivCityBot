package com.resliv.city_bot;

import com.resliv.city_bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CityBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityBotApplication.class, args);
    }

    @Autowired
    CityService cityService;

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {


        cityService.getAll().forEach(System.out::println);
    }

}
