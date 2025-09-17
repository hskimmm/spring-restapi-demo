package com.spring.restapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WriteBoardDTO {
    @NotEmpty(message = "게시글 제목을 입력하세요")
    private String title;

    @NotEmpty(message = "게시글 작성자를 입력하세요")
    private String writer;

    @NotEmpty(message = "게시글 내용을 입력하세요")
    private String content;
}
