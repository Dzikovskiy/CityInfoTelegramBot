package com.dzikovskiy.cityBot.TelegramBot;

import com.dzikovskiy.cityBot.Entities.City;
import com.dzikovskiy.cityBot.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:application.properties")
public class TelegramBot extends TelegramWebhookBot {

    @Autowired
    public CityRepository cityRepository;

    @Value("${telegrambot.userName}")
    private String botName;

    @Value("${telegrambot.botToken}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return "/";
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(message, "Введите название города, чтобы узнать интересные места: ");
                    break;
                default:
                    if (isCityExists(message.getText())) {
                        try {
                            City city = cityRepository.findByName(message.getText());
                            sendMsg(message, "В " + city.getName() + ":\n" + city.getCitySights());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        sendMsg(message, "Про такой город я ещё не знаю.");
                    }
            }
        }
        return null;
    }

    private void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private boolean isCityExists(String cityName) {
        City city = cityRepository.findByName(cityName);
        return city != null;
    }

}