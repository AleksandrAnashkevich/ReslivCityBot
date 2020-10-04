package com.resliv.city_bot.bot;

import com.resliv.city_bot.bot.message.factory.MessageFactory;
import com.resliv.city_bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
public class CityBot extends TelegramLongPollingBot {

    private TelegramBotsApi telegramBotsApi;
    private MessageFactory messageFactory;

    public CityBot(MessageFactory messageFactory) {
        this.telegramBotsApi = new TelegramBotsApi();
        this.messageFactory = messageFactory;
    }

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        String response = messageFactory.createMessage(message).send();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText(response);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "CityMessageReslivbot";
    }

    @Override
    public String getBotToken() {
        return "1132435302:AAGILmsnnbZSTGMLcF7jqZbHuZP1fmXZ9zo";
    }

    @PostConstruct
    public void registryBot() {
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
