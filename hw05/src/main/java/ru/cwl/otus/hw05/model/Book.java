package ru.cwl.otus.hw05.model;

import java.util.Set;

/**
 * Created by vadim.tishenko
 * on 18.07.2018 20:53.
 */
public class Book {
    int id;
    String title;
    Set<Autor> authors;
    Topic genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Autor> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topic getGenre() {
        return genre;
    }

    public void setGenre(Topic genre) {
        this.genre = genre;
    }
}
