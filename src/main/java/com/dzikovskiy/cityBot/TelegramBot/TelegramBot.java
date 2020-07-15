package com.dzikovskiy.cityBot.TelegramBot;

import com.dzikovskiy.cityBot.Entities.City;
import com.dzikovskiy.cityBot.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
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
        return botName;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setReplyToMessageId(message.getMessageId());

            switch (message.getText()) {
                case "/start":
                    sendMessage.setText("Введите название города, чтобы узнать интересные места: ");

                    return sendMessage;
                default:
                    if (isCityExists(message.getText())) {
                        try {
                            City city = cityRepository.findByName(message.getText());
                            sendMessage.setText("В " + city.getName() + ":\n" + city.getCitySights());

                            return sendMessage;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        sendMessage.setText("Про такой город я ещё не знаю.");

                        return sendMessage;
                    }
            }
        }
        return null;
    }

    //check if city is in database
    private boolean isCityExists(String cityName) {
        City city = cityRepository.findByName(cityName);
        return city != null;
    }

}