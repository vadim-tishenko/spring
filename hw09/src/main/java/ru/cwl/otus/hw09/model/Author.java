package ru.cwl.otus.hw09.model;

/**
 * Created by vadim.tishenko
 * on 18.07.2018 20:53.
 */
public class Author {
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
