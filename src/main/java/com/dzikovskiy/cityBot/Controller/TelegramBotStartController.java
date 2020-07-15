package com.dzikovskiy.cityBot.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class TelegramBotStartController {

    @RequestMapping(method = { RequestMethod.GET,
            RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> startStatusRequest() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
