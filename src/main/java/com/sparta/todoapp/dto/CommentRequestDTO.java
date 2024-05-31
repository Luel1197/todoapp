package com.sparta.todoapp.dto;


import com.sparta.todoapp.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String comment;
    private String userName;
    private String password;

    public Comment toEntity() {
        return Comment.builder().comment(comment).user(userName).
    }
}
