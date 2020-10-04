package com.resliv.city_bot.bot.message.factory.impl;

import com.resliv.city_bot.bot.message.Message;
import com.resliv.city_bot.bot.message.factory.MessageFactory;
import com.resliv.city_bot.bot.message.impl.MessageCity;
import com.resliv.city_bot.bot.message.impl.MessageInfo;
import com.resliv.city_bot.bot.message.impl.MessageStart;
import com.resliv.city_bot.service.CityService;
import com.resliv.city_bot.util.ConstantCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageFactoryImpl implements MessageFactory {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public Message createMessage(String command) {
        switch (command) {
            case ConstantCommand.START_COMMAND:
                return new MessageStart();
            case ConstantCommand.INFO_COMMAND:
                return new MessageInfo();
            default:
                return new MessageCity(command, cityService);
        }
    }
}
