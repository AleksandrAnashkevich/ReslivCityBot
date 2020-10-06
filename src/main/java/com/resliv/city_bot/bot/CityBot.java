package com.resliv.city_bot.bot;

import com.resliv.city_bot.bot.message.factory.MessageFactory;
import org.springframework.beans.factory.annotation.Value;
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
@PropertySource("classpath:telegram.properties")
public class CityBot extends TelegramLongPollingBot {

    @Value("${resliv.bot.name}")
    private String botName;
    @Value("${resliv.bot.token}")
    private String botToken;
    private final TelegramBotsApi telegramBotsApi;
    private final MessageFactory messageFactory;

    public CityBot(MessageFactory messageFactory) {
        this.telegramBotsApi = new TelegramBotsApi();
        this.messageFactory = messageFactory;
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
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
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
