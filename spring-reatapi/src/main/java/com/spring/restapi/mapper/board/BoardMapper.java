package com.spring.restapi.mapper.board;

import com.spring.restapi.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoards();
}
