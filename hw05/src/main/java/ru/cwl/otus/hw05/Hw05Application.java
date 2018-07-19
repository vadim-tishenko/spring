package ru.cwl.otus.hw05;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.cwl.otus.hw05.dao.BooksDao;
import ru.cwl.otus.hw05.model.Book;

import java.sql.SQLException;
import java.util.List;

import static ru.cwl.otus.hw05.BookBuilder.n;


@SpringBootApplication
public class Hw05Application {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Hw05Application.class, args);
        Console.main(args);

        BooksDao booksDao = ctx.getBean(BooksDao.class);


        BookBuilder bb = new BookBuilder();
        Book b1 = n()
                .title("Kafka: The Definitive Guide")
                .by("Gwen Shapira", "Neha Narkhede", "Todd Palino")
                .genre("Apache Web Server, Message Queues").build();

        Book b2 = n()
                .title("Microservice Architecture")
                .by("Mike Amundsen", "Matt McLarty", "Ronnie Mitra", "Irakli Nadareishvili")
                .genre("Enterprise Architecture").build();

        Book b3 = n().title("Pattern-Oriented Software Architecture, Volume 1, A System of Patterns")
                .by("Michael Stal", "Peter Sommerlad", "Hans Rohnert", "Regine Meunier", "Frank Buschmann")
                .genre("Design Patterns").build();

        Book b4 = n().title("Pattern-Oriented Software Architecture, Volume 2, Patterns for Concurrent and Networked Objects")
                .by("Frank Buschmann", "Hans Rohnert", "Michael Stal", "Douglas C. Schmidt")
                .genre("Enterprise Architecture").build();


        booksDao.insert(b1);
        booksDao.insert(b2);
        booksDao.insert(b3);
        booksDao.insert(b4);

        System.out.println(booksDao.count());

        List<Book> res = booksDao.findAll();

        /** *
         * I Heart Logs
         *  16 reviews
         * by Jay Kreps
         * Publisher: O'Reilly Media, Inc.
         * Release Date: October 2014
         * ISBN: 9781491909379
         * Topics: Databases
         *
         * Production-Ready Microservices
         *  9 reviews
         * by Susan J. Fowler
         * Publisher: O'Reilly Media, Inc.
         * Release Date: December 2016
         * ISBN: 9781491965962
         * Topics: Engineering Strategy & Execution
         *
         * Akka in Action
         *  2 reviews
         * by Raymond Roestenburg Rob Bakker Rob Williams
         * Publisher: Manning Publications
         * Release Date: September 2016
         * ISBN: 9781617291012
         * Topics: Scala
         *

         *
         */

    }


}
