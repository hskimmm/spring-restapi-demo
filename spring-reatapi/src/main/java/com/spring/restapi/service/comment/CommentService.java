package com.spring.restapi.service.comment;

import com.spring.restapi.response.ApiResponse;

public interface CommentService {
    ApiResponse<?> getComments(int id);
}
