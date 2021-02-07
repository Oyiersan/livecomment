package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
public class AddUserCommentDTO  implements Serializable {

    private static final long serialVersionUID = 1490414236629992628L;

    @ApiModelProperty("用户id")
    @NotNull
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户编码")
    private String userCode;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("评论")
    @NotBlank
    private String comment;
}