package com.spring.restapi.service.board;

import com.spring.restapi.domain.Board;
import com.spring.restapi.dto.UpdateBoardDTO;
import com.spring.restapi.dto.WriteBoardDTO;
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

    @Transactional
    @Override
    public ApiResponse<?> getBoard(int id) {
        try {
            //조회수 증가
            boardMapper.incrementViews(id);

            Board board = boardMapper.getBoard(id);
            return new ApiResponse<>(true, "게시글을 조회하였습니다", board);
        } catch (DataAccessException e) {
            log.error("게시글 상세 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 상세 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("게시글 상세 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 상세 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> writeBoard(WriteBoardDTO writeBoardDTO) {
        try {
            Board board = Board.builder()
                    .title(writeBoardDTO.getTitle())
                    .writer(writeBoardDTO.getWriter())
                    .content(writeBoardDTO.getContent())
                    .build();

            boardMapper.writeBoard(board);
            return new ApiResponse<>(true, "게시글을 등록하였습니다");
        } catch (DataAccessException e) {
            log.error("게시글 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("게시글 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 등록 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> updateBoard(UpdateBoardDTO updateBoardDTO) {
        try {
            Board board = Board.builder()
                    .id(updateBoardDTO.getId())
                    .title(updateBoardDTO.getTitle())
                    .writer(updateBoardDTO.getWriter())
                    .build();

            boardMapper.updateBoard(board);
            return new ApiResponse<>(true, "게시글을 수정하였습니다");
        } catch (DataAccessException e) {
            log.error("게시글 수정(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 수정 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("게시글 수정(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 수정 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> deleteBoard(int id) {
        try {
            boardMapper.deleteBoard(id);
            return new ApiResponse<>(true, "게시글을 삭제하였습니다");
        } catch (DataAccessException e) {
            log.error("게시글 삭제(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 삭제 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("게시글 삭제(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("게시글 삭제 중 오류가 발생하였습니다");
        }
    }
}
