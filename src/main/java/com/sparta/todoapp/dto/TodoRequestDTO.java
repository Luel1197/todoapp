package com.sparta.todoapp.dto;

import com.sparta.todoapp.entity.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDTO {
    private String title;

    private String content;

    private String userName;

    private String password;

    public Todo toEntitiy(){
        return Todo.builder().title(title).content(content).userName(userName).password(password).build();
    }
}
