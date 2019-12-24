package app.controller;

import app.dto.SongRequest;
import app.model.TelegramUser;
import app.model.User;
import app.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tlg")
public class TelegramController {

    private final TelegramService telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping(value = "/song")
    public void add(@RequestBody SongRequest songRequest) {
        telegramService.sendSongToBot(songRequest);
    }

    @PostMapping(value = "/approve")
    public void approve (@RequestBody SongRequest songRequest) {
        System.out.println(songRequest.getSongId());
    }
}
