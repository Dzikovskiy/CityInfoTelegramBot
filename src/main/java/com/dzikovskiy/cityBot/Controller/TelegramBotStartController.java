package com.dzikovskiy.cityBot.Controller;


import com.dzikovskiy.cityBot.TelegramBot.TelegramBot;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;


//that controller needs for telegram to start bot with webhook
@RestController
public class TelegramBotStartController {

    private final TelegramBot telegramBot;

    public TelegramBotStartController(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    //telegram sends post request to sever to check if server available
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
