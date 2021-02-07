package com.oyiersan.livecomment.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserCommentTopVO implements Serializable {

    private static final long serialVersionUID = 3490414136629992928L;
    @ApiModelProperty("评论id")
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("评论id")
    private Long commentId;

    @ApiModelProperty("评论次数")
    private Integer num;

    @ApiModelProperty("评论日期")
    private LocalDate creatDate;

}
