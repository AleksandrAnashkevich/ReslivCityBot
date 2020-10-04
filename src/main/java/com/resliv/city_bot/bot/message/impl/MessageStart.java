package com.resliv.city_bot.bot.message.impl;

import com.resliv.city_bot.bot.message.Message;
import com.resliv.city_bot.util.ConstantMessage;

public class MessageStart implements Message {

    @Override
    public String send() {
        return ConstantMessage.START_MESSAGE;
    }
}
