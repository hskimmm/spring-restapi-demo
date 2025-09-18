package com.spring.restapi.mapper.comment;

import com.spring.restapi.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getComments(int id);

    void writeComment(Comment comment);

    void updateComment(Comment comment);
}
