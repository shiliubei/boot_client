package app.model;


import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;

public class TelegramUser {

    @Id
    private Long chatId;
    private String songName;
    private Long songId;
    @Transient
    private File track;

    private String messageFromServer;


    public TelegramUser() {
    }

    public TelegramUser(Long chatId, String songName, Long songId, File track, String messageFromServer) {
        this.chatId = chatId;
        this.songName = songName;
        this.songId = songId;
        this.track = track;
        this.messageFromServer = messageFromServer;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public File getTrack() {
        return track;
    }

    public void setTrack(File track) {
        this.track = track;
    }

    public String getMessageFromServer() {
        return messageFromServer;
    }

    public void setMessageFromServer(String messageFromServer) {
        this.messageFromServer = messageFromServer;
    }
}
