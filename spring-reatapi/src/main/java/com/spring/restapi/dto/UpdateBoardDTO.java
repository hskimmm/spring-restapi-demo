package com.spring.restapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBoardDTO {
    @NotNull(message = "게시글을 찾을 수 없습니다")
    private int id;
    
    @NotEmpty(message = "제목을 입력하세요")
    private String title;
    
    @NotEmpty(message = "작성자를 입력하세요")
    private String writer;
}
