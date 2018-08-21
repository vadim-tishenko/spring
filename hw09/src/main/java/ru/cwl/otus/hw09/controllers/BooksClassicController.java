package ru.cwl.otus.hw09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.cwl.otus.hw09.model.Author;
import ru.cwl.otus.hw09.model.Book;
import ru.cwl.otus.hw09.model.Comment;
import ru.cwl.otus.hw09.repository.BooksRepository;
import ru.cwl.otus.hw09.repository.CommentsRepository;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BooksClassicController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    CommentsRepository commentsRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    String books1(Model model) {
        model.addAttribute("books", booksRepository.findAll());
        return "books";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/book/{id}")
    String getBook(@PathVariable String id, Model model) {
        model.addAttribute("book", booksRepository.findById(id).get());
        model.addAttribute("comments", commentsRepository.findByBookIdOrderByDateTimeDesc(id));
        return "book";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/book/edit/{id}")
    String editBook(@PathVariable String id, Model model) {
        Book book = booksRepository.findById(id).get();
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("title", book.getTitle());
        map.put("authors", book.getAuthors().stream().map(a->a.getName()).collect(Collectors.joining(",")));
        map.put("tags", String.join(",", book.getTags()));

        model.addAttribute("book", map);
        return "bookedit";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/book/update")
    String updateBook(
            @PathParam("id") String id,
            @PathParam("title") String title,
            @PathParam("authors") String authors,
            @PathParam("tags") String tags
    ) {
        Book book = booksRepository.findById(id).get();
        book.setTitle(title);
        String[] tagsArray = tags.split(",");
        book.getTags().addAll(Arrays.asList(tagsArray));
        String[] a = authors.split(",");
        book.getAuthors().clear();
        for (String s : a) {
            Author aa = new Author();
            aa.setName(s);
            book.getAuthors().add(aa);
        }
        book = booksRepository.save(book);
//        return "redirect:/books";
        return "redirect:/book/" + book.getId();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/book")
    String addBook(
            @PathParam("title") String title,
            @PathParam("authors") String authors,
            @PathParam("tags") String tags
    ) {
        Book book = new Book();
        book.setTitle(title);
        String[] tagsArray = tags.split(",");
        book.getTags().addAll(Arrays.asList(tagsArray));
        String[] a = authors.split(",");
        for (String s : a) {
            Author aa = new Author();
            aa.setName(s);
            book.getAuthors().add(aa);
        }
        book = booksRepository.save(book);
//        return "redirect:/books";
        return "redirect:/book/" + book.getId();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/comment")
    String addComment(@PathParam("bookId") String bookId, @PathParam("text") String text,
                      @PathParam("user") String user, Model model) {
        Comment comment = new Comment(bookId, user, text);
        commentsRepository.save(comment);

        return "redirect:/book/" + bookId;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/comment/del/{id}")
    String deleteComment(@PathVariable String id, Model model) {
        Comment comment = commentsRepository.findById(id).get();
        commentsRepository.deleteById(id);
        return "redirect:/book/" + comment.getBookId();
    }


    @RequestMapping("/books/tag/{tag}")
    String findByTagLike(@PathVariable("tag") String tag, Map model) {
        model.put("books", booksRepository.findByTagsRegex(tag));
        return "books";
    }

    @RequestMapping("/books/title/{title}")
    String findByTitle(@PathVariable("title") String tag, Map model) {
        model.put("books", booksRepository.findByTitleRegex(tag));
        return "books";
    }

    @RequestMapping("/books/author/{name}")
    String findByAuthor(@PathVariable("name") String name, Map model) {
        model.put("books", booksRepository.findByAuthors(name));
        return "books";
    }
}
