package ru.cwl.otus.hw09.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by vadim.tishenko
 * on 21.08.2018 20:52.
 */
public class Comment {
    @Id
    private String id;
    private String bookId;
    private String userName;
    private String text;
    private LocalDateTime dateTime;

    public Comment() {
    }

    public Comment(String bookId, String userName, String text) {
        this.bookId = bookId;
        this.userName = userName;
        this.text = text;
        dateTime=LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
