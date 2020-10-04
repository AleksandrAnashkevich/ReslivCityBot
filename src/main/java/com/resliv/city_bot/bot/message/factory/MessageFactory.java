package com.resliv.city_bot.bot.message.factory;

import com.resliv.city_bot.bot.message.Message;

@FunctionalInterface
public interface MessageFactory {
    Message createMessage(String command);
}
