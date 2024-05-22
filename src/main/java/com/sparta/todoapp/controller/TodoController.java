package com.sparta.todoapp.controller;

import com.sparta.todoapp.CommonResponse;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import com.sparta.todoapp.service.TodoService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1.0/todo")
@RestController
@AllArgsConstructor
public class TodoController {

    public final TodoService todoService;



    @PostMapping
    public ResponseEntity<CommonResponse<TodoResponseDTO>> postTodo(@RequestBody TodoRequestDTO dto){
        Todo  todo = todoService.createTodo(dto);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(CommonResponse.<TodoResponseDTO>builder()
            .statusCode(HttpStatus.OK.value())
            .msg("생성완료됨")
            .data(response)
            .build());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<CommonResponse<TodoResponseDTO>> getTodo(@PathVariable Long todoId){
        Todo todo = todoService.getTodo(todoId);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(CommonResponse.<TodoResponseDTO>builder()
            .statusCode(HttpStatus.OK.value())
            .msg("조회완료됨")
            .data(response)
            .build());
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<TodoResponseDTO>>> getTodos() {
        List<Todo> todos = todoService.getTodos();
        List<TodoResponseDTO> response = todos.stream().map(TodoResponseDTO::new).collect(
            Collectors.toList());
        return ResponseEntity.ok().body(CommonResponse.<List<TodoResponseDTO>>builder()
            .statusCode(HttpStatus.OK.value())
            .msg("목록조회완료됨")
            .data(response)
            .build());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<CommonResponse<TodoResponseDTO>> putTodo(@PathVariable Long todoId, @RequestBody TodoRequestDTO dto){
        Todo todo = todoService.updateTodo(todoId, dto);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(CommonResponse.<TodoResponseDTO>builder()
            .statusCode(HttpStatus.OK.value())
            .msg("수정완료됨")
            .data(response)
            .build());
    }


    @DeleteMapping("/{todoId}")
    public ResponseEntity<CommonResponse> deleteTodo(@PathVariable Long todoId, @RequestBody TodoRequestDTO dto) {
        todoService.deleteTodo(todoId, dto.getPassword());
        return ResponseEntity.ok().body(CommonResponse.builder()
            .statusCode(HttpStatus.OK.value())
            .msg("삭제완료됨")
            .build());
    }
}
