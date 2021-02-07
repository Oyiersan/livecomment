package com.oyiersan.livecomment.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class UserTopListVO implements Serializable {

    private static final long serialVersionUID = 3491414136629992928L;

    @ApiModelProperty("日期")
    private String date;

    private List<UserCommentTopVO> topVOList;

}
