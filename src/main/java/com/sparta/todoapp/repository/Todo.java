package com.sparta.todoapp.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Todo {

    @Id // <- 이 어노테이션을 통해 이 필드를 id로 쓰겠다 명시
    //자동으로 생성되는 밸류  방법은 시퀀스 연속적으로
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "todo_id", nullable = false)
    private Long todoid;

    private String title;

    private String content;

    private String userName;

    private String password;

    private LocalDateTime createdAt; //작성일


    @Builder
    public Todo(String title, String content, String userName, String password) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
