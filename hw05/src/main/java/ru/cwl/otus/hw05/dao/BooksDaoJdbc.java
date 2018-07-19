package ru.cwl.otus.hw05.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.cwl.otus.hw05.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BooksDaoJdbc implements BooksDao {
    private JdbcOperations operations;
    private NamedParameterJdbcOperations namedOperations;

    private AtomicInteger integer=new AtomicInteger();

    public BooksDaoJdbc(JdbcOperations operations, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.operations = operations;
        this.namedOperations = namedParameterJdbcOperations;
    }


    @Override
    public int count() {
        return operations.queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public Book findById(int id) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("id", id);
        Book p = namedOperations.queryForObject("select * from books where id=:id", param, rowMapper);
        return p;
    }

    private final RowMapper<Book> rowMapper = (resultSet, i) -> {
        Book book=new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        return book;
    };

    @Override
    public List<Book> findAll() {
        return operations.query("select * from books", rowMapper);
    }

    @Override
    public void insert(Book book) {
        HashMap<String, Object> map = new HashMap<>();
        book.setId(integer.incrementAndGet());
        map.put("id", book.getId());
        map.put("title", book.getTitle());
        namedOperations.update("insert into books(id,title) values(:id,:title)",map);
    }

    @Override
    public void deleteById(int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        namedOperations.update("delete  from books where id=:id", map);
    }


}
