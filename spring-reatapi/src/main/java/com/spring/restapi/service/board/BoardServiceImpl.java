package com.spring.restapi.service.board;

import com.spring.restapi.domain.Board;
import com.spring.restapi.mapper.board.BoardMapper;
import com.spring.restapi.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> getBoards() {
        try {

            List<Board> boardList = boardMapper.getBoards();
            return new ApiResponse<>(true, "성공적으로 전체 게시글을 조회하였습니다", boardList);
        } catch (DataAccessException e) {
            log.error("전체 게시글 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("전체 게시글 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("전체 게시글 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("전체 게시글 조회 중 오류가 발생하였습니다");
        }
    }
}
