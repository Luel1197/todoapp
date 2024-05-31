package com.sparta.todoapp.controller;


import com.sparta.todoapp.dto.CommentRequestDTO;
import com.sparta.todoapp.entity.Comment;
import com.sparta.todoapp.service.CommentService;
import com.sparta.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1.0/{todoId}")
@RestController
@CrossOrigin
public class CommentController {


    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public String addComment(@PathVariable String todoId, @RequestBody CommentRequestDTO commentDto) {

        Comment comment = CommentService.addComment(commentDto);

        return "Comment successful";
    }
}
