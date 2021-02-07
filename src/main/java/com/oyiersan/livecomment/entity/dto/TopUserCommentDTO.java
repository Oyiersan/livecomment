package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TopUserCommentDTO extends PageReqDTO {

    private static final long serialVersionUID = 3490414231629992628L;

    @ApiModelProperty("评论日期 YYYY-MM-DD")
    @NotBlank(message = "日期不能为空")
    private String commentDate;

}
