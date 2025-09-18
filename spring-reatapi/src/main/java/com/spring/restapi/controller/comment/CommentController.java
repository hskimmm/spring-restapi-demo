package com.spring.restapi.controller.comment;

import com.spring.restapi.dto.UpdateCommentDTO;
import com.spring.restapi.dto.WriteCommentDTO;
import com.spring.restapi.response.ApiResponse;
import com.spring.restapi.service.comment.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Log4j2
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getComments(@PathVariable(value = "id") int id) {
        ApiResponse<?> response = commentService.getComments(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> writeComment(@Valid @RequestBody WriteCommentDTO writeCommentDTO) {
        ApiResponse<?> response = commentService.writeComment(writeCommentDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> updateComment(@Valid @RequestBody UpdateCommentDTO updateCommentDTO) {
        ApiResponse<?> response = commentService.updateComment(updateCommentDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteComment(@PathVariable(value = "id") int id) {
        ApiResponse<?> response = commentService.deleteComment(id);
        return ResponseEntity.ok(response);
    }
}
