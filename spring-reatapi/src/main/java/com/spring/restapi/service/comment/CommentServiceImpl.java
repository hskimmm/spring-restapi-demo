package com.spring.restapi.service.comment;

import com.spring.restapi.domain.Comment;
import com.spring.restapi.mapper.comment.CommentMapper;
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
public class CommentServiceImpl implements CommentService{
    private final CommentMapper commentMapper;

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> getComments(int id) {
        try {
            List<Comment> comments = commentMapper.getComments(id);
            return new ApiResponse<>(true, "전체 댓글 목록을 조회하였습니다", comments);
        } catch (DataAccessException e) {
            log.error("댓글 전체 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 전체 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("댓글 전체 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 전체 조회 중 오류가 발생하였습니다");
        }
    }
}
