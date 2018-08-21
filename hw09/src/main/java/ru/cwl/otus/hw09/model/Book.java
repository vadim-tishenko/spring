package ru.cwl.otus.hw09.model;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vadim.tishenko
 * on 18.07.2018 20:53.
 */
public class Book {
    @Id
    private String id;
    private String title;
    private Set<Author> authors=new HashSet<>();
    private Set<String> tags=new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getTags() {
        return tags;
    }

}
