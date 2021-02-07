package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikeItVideoDTO {

    private static final long serialVersionUID = 3491414231629992628L;

    @ApiModelProperty("视频点赞人")
    private String openid;

}
