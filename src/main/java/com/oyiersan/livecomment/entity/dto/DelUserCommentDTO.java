package com.oyiersan.livecomment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
public class DelUserCommentDTO  implements Serializable {

    private static final long serialVersionUID = 3490414236629992618L;

    @ApiModelProperty("评论id")
    @NotNull
    private Long commentId;

}