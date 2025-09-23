package com.spring.restapi.service.board;

import com.spring.restapi.domain.Board;
import com.spring.restapi.dto.UpdateBoardDTO;
import com.spring.restapi.dto.WriteBoardDTO;
import com.spring.restapi.response.ApiResponse;
import com.spring.restapi.util.Pagination;
import jakarta.validation.Valid;

public interface BoardService {
    ApiResponse<?> getBoards(Pagination pagination);

    ApiResponse<?> getBoard(int id);

    ApiResponse<?> writeBoard(@Valid WriteBoardDTO writeBoardDTO);

    ApiResponse<?> updateBoard(@Valid UpdateBoardDTO updateBoardDTO);

    ApiResponse<?> deleteBoard(int id);

    int count(Pagination pagination);
}
