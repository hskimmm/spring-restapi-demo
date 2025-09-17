package com.spring.restapi.mapper.board;

import com.spring.restapi.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoards();

    Board getBoard(int id);

    void incrementViews(int id);

    void writeBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int id);
}
