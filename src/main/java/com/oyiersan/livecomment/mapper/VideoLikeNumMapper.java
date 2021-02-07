package com.oyiersan.livecomment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oyiersan.livecomment.entity.VideoLikeNum;
import org.apache.ibatis.annotations.Select;

public interface VideoLikeNumMapper extends BaseMapper<VideoLikeNum> {

    @Select("SELECT SUM(like_num) FROM video_like_num")
    int sumVideoLikeNum();

}
