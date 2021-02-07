package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PageReqDTO implements Serializable {

    private static final long serialVersionUID = 3490414236629992628L;

    @ApiModelProperty("当前页")
    @NotNull(message = "当前第几页不能为空")
    private Integer pageNo;

    @ApiModelProperty("每页显示数据")
    @NotNull(message = "每页显示几行不能为空")
    private Integer pageSize;
}