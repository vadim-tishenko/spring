package ru.cwl.otus.hw09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.cwl.otus.hw09.BookBuilder;
import ru.cwl.otus.hw09.model.Book;
import ru.cwl.otus.hw09.repository.BooksRepository;

import java.util.List;

import static ru.cwl.otus.hw09.BookBuilder.n;

@RestController()
public class BooksRestController {
    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/books/all")
    List<Book> getAll() {
        return booksRepository.findAll();
    }

    @GetMapping("/books/addtestdata")
    String getAddTestData() {
        insertTestData();
        return "ok";
    }


    private void insertTestData() {
        BookBuilder bb = new BookBuilder();
        Book b1 = n()
                .title("Kafka: The Definitive Guide")
                .by("Gwen Shapira", "Neha Narkhede", "Todd Palino")
                .tags("Apache Web Server", "Message Queues").build();

        Book b2 = n()
                .title("Microservice Architecture")
                .by("Mike Amundsen", "Matt McLarty", "Ronnie Mitra", "Irakli Nadareishvili")
                .tags("Enterprise Architecture").build();

        Book b3 = n().title("Pattern-Oriented Software Architecture, Volume 1, A System of Patterns")
                .by("Michael Stal", "Peter Sommerlad", "Hans Rohnert", "Regine Meunier", "Frank Buschmann")
                .tags("Design Patterns").build();

        Book b4 = n().title("Pattern-Oriented Software Architecture, Volume 2, Patterns for Concurrent and Networked Objects")
                .by("Frank Buschmann", "Hans Rohnert", "Michael Stal", "Douglas C. Schmidt")
                .tags("Enterprise Architecture").build();


        booksRepository.save(b1);
        booksRepository.save(b2);
        booksRepository.save(b3);
        booksRepository.save(b4);
    }


}
