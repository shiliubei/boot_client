package app.controller;

import app.dto.SongRequest;
import app.dto.SongResponce;
import app.model.TelegramUser;
import app.model.User;
import app.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping(value = "/api/tlg")
public class TelegramController {

    private final TelegramService telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping(value = "/song")
    public SongResponce searchRequestedSong (@RequestBody SongRequest songRequest) {
        File file = new File("D:\\pacman\\We Wish You A Merry Christmas.mp3");
        SongResponce songResponce = new SongResponce(songRequest.getChatId(),25122019l, file);
        return songResponce;
    }

    @PostMapping(value = "/approve")
    public void approve (@RequestBody SongRequest songRequest) {
        System.out.println(songRequest.getSongId());
    }
}
