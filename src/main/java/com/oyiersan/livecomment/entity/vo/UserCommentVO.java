package com.oyiersan.livecomment.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserCommentVO implements Serializable {

    private static final long serialVersionUID = 3490414236629992128L;
    @ApiModelProperty("评论id")
    private Long userId;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("评论id")
    private Long commentId;
    @ApiModelProperty("评论")
    private String comment;
    @ApiModelProperty("评论时间")
    private LocalDateTime commentDateTime;

}
