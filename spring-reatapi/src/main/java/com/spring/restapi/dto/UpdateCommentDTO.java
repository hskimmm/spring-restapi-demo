package com.spring.restapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentDTO {
    @NotNull(message = "댓글을 찾을 수 없습니다")
    private int id;

    @NotEmpty(message = "댓글 내용을 입력하세요")
    private String content;
}
