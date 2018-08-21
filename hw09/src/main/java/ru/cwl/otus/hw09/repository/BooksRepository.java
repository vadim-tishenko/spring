package ru.cwl.otus.hw09.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.cwl.otus.hw09.model.Book;

import java.util.List;

public interface BooksRepository extends MongoRepository<Book,String> {

    List<Book> findByTitleRegex(String title);
    List<Book> findByTagsRegex(String tag);
    @Query("{ 'authors.name':{'$regex':'?0'}}")
    List<Book> findByAuthors(String name);
}
