package com.sparta.todoapp.service;

import com.sparta.todoapp.dto.CommentRequestDTO;
import com.sparta.todoapp.entity.Comment;
import com.sparta.todoapp.entity.Todo;
import com.sparta.todoapp.repository.CommentRepository;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final TodoRepository todoRepository;
    private CommentRepository commentRepository;

    //댓글 생성
    public Comment addComment(CommentRequestDTO commentDto) {
        var newComment = commentDto.toEntity();
        return commentRepository.save(newComment);
    }

    //댓글 조회
   public Comment getComment(Long CommentId) {
        return commentRepository.findById(CommentId).orElseThrow(IllegalArgumentException::new);
   }
    //댓글 수정
   public Comment updateComment(Long CommentId, CommentRequestDTO commentDto) {
       Comment comment = getComment(CommentId);

       comment.setComment(commentDto.getComment());

       return commentRepository.save(comment);
   }

   public void deleteComment(Long CommentId) {
        todoRepository.deleteById(CommentId);
   }
}
