package com.sparta.todoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.statement.comment.Comment;
import org.hibernate.annotations.Comments;

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

    @OneToMany(mappedBy = "todo")
    private List<Todo> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
