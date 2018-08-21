package ru.cwl.otus.hw09.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.cwl.otus.hw09.model.Comment;

import java.util.List;

/**
 * Created by vadim.tishenko
 * on 21.08.2018 21:08.
 */
public interface CommentsRepository extends MongoRepository<Comment, String> {
    List<Comment> findByBookIdOrderByDateTimeDesc(String bookId);
}
