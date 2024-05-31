package com.sparta.todoapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    private String username;
    private String userLoginId;
    private String password;
    private String userAuth;
    private LocalDateTime userAt;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList = new ArrayList<>();


    @Builder
    public User(String username, String userLoginId, String password, String userAuth) {
        this.username = username;
        this.userLoginId = userLoginId;
        this.password = password;
        this.userAuth = userAuth;
        this.userAt = LocalDateTime.now();
    }
}
