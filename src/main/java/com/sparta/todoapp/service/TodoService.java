package com.sparta.todoapp.service;


import com.sparta.todoapp.controller.TodoRequestDTO;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
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

    //할일 단건 조회
    public Todo getTodo(Long todoId) {
       return todoRepository.findById(todoId).orElseThrow(IllegalArgumentException::new);
    }

    //목록조회
    public List<Todo> getTodos() {
        return todoRepository.findAll(Sort.by("createdAt").descending());
    }


}
