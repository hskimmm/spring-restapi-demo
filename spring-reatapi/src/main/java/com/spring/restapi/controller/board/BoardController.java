package com.spring.restapi.controller.board;

import com.spring.restapi.domain.Board;
import com.spring.restapi.dto.UpdateBoardDTO;
import com.spring.restapi.dto.WriteBoardDTO;
import com.spring.restapi.response.ApiResponse;
import com.spring.restapi.service.board.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getBoards() {
        ApiResponse<?> response = boardService.getBoards();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getBoard(@PathVariable(value = "id") int id) {
        ApiResponse<?> response = boardService.getBoard(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> writeBoard(@Valid @ModelAttribute WriteBoardDTO writeBoardDTO) {
        log.info("writeBoardDTO = {}", writeBoardDTO);
        ApiResponse<?> response = boardService.writeBoard(writeBoardDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> updateBoard(@Valid @RequestBody UpdateBoardDTO updateBoardDTO) {
        ApiResponse<?> response = boardService.updateBoard(updateBoardDTO);
        return ResponseEntity.ok(response);
    }
}
