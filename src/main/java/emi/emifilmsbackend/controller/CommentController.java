package emi.emifilmsbackend.controller;


import emi.emifilmsbackend.model.Comment;
import emi.emifilmsbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comments/{movieId}")
    public List<Comment> getCommentsByMovieId(@PathVariable Long movieId) {
        return commentRepository.findByMovieId(movieId);
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }



}
