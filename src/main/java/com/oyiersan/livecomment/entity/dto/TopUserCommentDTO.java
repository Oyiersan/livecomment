package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TopUserCommentDTO extends PageReqDTO {

    private static final long serialVersionUID = 3490414231629992628L;

    @ApiModelProperty("评论日期 YYYY-MM-DD")
    private String commentDate;

}
