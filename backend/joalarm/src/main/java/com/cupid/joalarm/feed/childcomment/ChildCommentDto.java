package com.cupid.joalarm.feed.childcomment;

import io.swagger.annotations.ApiParam;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildCommentDto {

    @ApiParam(value = "대댓글 id")
    private Long childId;

    @ApiParam(value = "대댓글 작성 시각")
    private LocalDateTime createdAt;

    @ApiParam(value = "대댓글 내용")
    private String content;

    @ApiParam(value = "댓글 id")
    private Long commentId;

    @ApiParam(value = "유저 id")
    private Long userId;

}
