package ru.cwl.otus.hw09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.cwl.otus.hw09.model.Book;
import ru.cwl.otus.hw09.repository.BooksRepository;

import java.util.List;

@SpringBootApplication
public class Hw09Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Hw09Application.class, args);
        BooksRepository re = ctx.getBean(BooksRepository.class);
        List<Book> all = re.findAll();
    }


}
