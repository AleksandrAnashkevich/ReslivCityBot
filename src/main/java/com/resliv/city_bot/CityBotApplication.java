package com.resliv.city_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class CityBotApplication {
    static {

    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(CityBotApplication.class, args);
    }

}
