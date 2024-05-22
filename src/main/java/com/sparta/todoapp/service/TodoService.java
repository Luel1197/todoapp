package com.sparta.todoapp.service;


import com.sparta.todoapp.controller.TodoRequestDTO;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //생성자 모든파라미터가 주입받을 수 있는 생성자 만들기
public class TodoService {

    private TodoRepository todoRepository;

    //할일 생성
    public Todo createTodo(TodoRequestDTO dto) {
        var newTodo = dto.toEntitiy();
        return todoRepository.save(newTodo);
    }
}