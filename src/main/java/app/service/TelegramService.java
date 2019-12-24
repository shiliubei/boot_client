package app.service;

import app.dto.SongRequest;
import app.dto.SongResponce;
import app.model.TelegramUser;

public interface TelegramService {
    SongResponce sendSongToBot(SongRequest telegramUser);

    TelegramUser approve(TelegramUser telegramUser);
}
