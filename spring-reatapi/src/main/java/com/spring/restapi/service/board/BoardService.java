package com.spring.restapi.service.board;

import com.spring.restapi.response.ApiResponse;

public interface BoardService {
    ApiResponse<?> getBoards();

    ApiResponse<?> getBoard(int id);
}
