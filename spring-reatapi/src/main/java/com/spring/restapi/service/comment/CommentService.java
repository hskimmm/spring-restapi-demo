package com.spring.restapi.service.comment;

import com.spring.restapi.dto.UpdateCommentDTO;
import com.spring.restapi.dto.WriteCommentDTO;
import com.spring.restapi.response.ApiResponse;
import jakarta.validation.Valid;

public interface CommentService {
    ApiResponse<?> getComments(int id);

    ApiResponse<?> writeComment(@Valid WriteCommentDTO writeCommentDTO);

    ApiResponse<?> updateComment(@Valid UpdateCommentDTO updateCommentDTO);
}
