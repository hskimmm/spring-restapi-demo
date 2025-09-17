package com.spring.restapi.controller.board;

import com.spring.restapi.response.ApiResponse;
import com.spring.restapi.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<ApiResponse<?>> getBoards() {
        ApiResponse<?> response = boardService.getBoards();
        return ResponseEntity.ok(response);
    }
}
