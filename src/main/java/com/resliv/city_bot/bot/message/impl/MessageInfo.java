package com.resliv.city_bot.bot.message.impl;

import com.resliv.city_bot.bot.message.Message;
import com.resliv.city_bot.util.ConstantMessage;

public class MessageInfo implements Message {

    @Override
    public String send() {
        return ConstantMessage.INFO_MESSAGE;
    }
}
