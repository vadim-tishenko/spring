package ru.cwl.otus.hw09;


import ru.cwl.otus.hw09.model.Author;
import ru.cwl.otus.hw09.model.Book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vadim.tishenko
 * on 18.07.2018 21:39.
 */
public class BookBuilder {
    String title="";
    Set<Author> autors=new HashSet<>();
    Set<String> tags=new HashSet<>();
    public static BookBuilder n() {
        return new BookBuilder();
    }

    public BookBuilder title(String title) {
        this.title=title;
        return this;
    }

    public BookBuilder by(String... authors) {
        for (String authorName : authors) {
            autors.add(new Author(authorName));
        }
        return this;
    }

    public BookBuilder tags(String ...tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }

    public Book build() {
        final Book book = new Book();
        book.setTitle(title);
        book.setAuthors(autors);
        book.getTags().addAll(tags);
        return book;
    }
}
