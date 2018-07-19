package ru.cwl.otus.hw05.dao;

import ru.cwl.otus.hw05.model.Book;

import java.util.List;

public interface BooksDao {
    int count();
    Book findById(int id);
    List<Book> findAll();
    void insert(Book Book);
    void deleteById(int id);
}
