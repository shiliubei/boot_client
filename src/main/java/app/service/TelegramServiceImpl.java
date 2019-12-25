package app.service;

import app.dto.SongRequest;
import app.dto.SongResponce;
import app.model.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Service
public class TelegramServiceImpl implements TelegramService {

    private final RestTemplate restTemplate;

    @Autowired
    public TelegramServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public SongResponce sendSongToBot(SongRequest songRequest) {
        String URL = "http://localhost:8888/bot/song";
        File file = new File("D:\\pacman\\We Wish You A Merry Christmas.mp3");
        SongResponce songResponce = new SongResponce(songRequest.getChatId(),25122019l, file);

        return restTemplate.postForObject(URL, songResponce, SongResponce.class);
    }

    @Override
    public TelegramUser approve(TelegramUser telegramUser) {
        String URL = "http://localhost:8888/bot/approve";
        return restTemplate.postForObject(URL, telegramUser, TelegramUser.class);
    }
}
