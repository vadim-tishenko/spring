package ru.cwl.otus.hw05;

import ru.cwl.otus.hw05.model.Autor;
import ru.cwl.otus.hw05.model.Book;
import ru.cwl.otus.hw05.model.Topic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vadim.tishenko
 * on 18.07.2018 21:39.
 */
class BookBuilder {
    String title="";
    Set<Autor> autors=new HashSet<>();
    String topic="";
    static BookBuilder n() {
        return new BookBuilder();
    }

    BookBuilder title(String title) {
        this.title=title;
        return this;
    }

    BookBuilder by(String... authors) {
        return this;
    }

    BookBuilder genre(String genre) {
        topic=genre;
        return this;
    }

    Book build() {
        final Book book = new Book();
        book.setTitle(title);
        book.setAuthors(autors);
        book.setGenre(new Topic(topic));
        return book;
    }
}
