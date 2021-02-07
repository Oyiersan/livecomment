package com.oyiersan.livecomment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oyiersan.livecomment.entity.UserComment;
import com.oyiersan.livecomment.entity.vo.UserCommentTopVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserCommentMapper extends BaseMapper<UserComment> {


    @Select("SELECT\n" +
            "  user_id userId,\n" +
            "  create_date creatDate,\n" +
            "  count( user_id ) num \n" +
            "FROM\n" +
            "  user_comment \n" +
            "\tWHERE create_date = #{commentDate}\n" +
            "GROUP BY\n" +
            "  user_id,\n" +
            "  create_date\n" +
            "\tORDER BY create_date, num DESC")
    List<UserCommentTopVO> topCommentList(@Param("commentDate") String commentDate);

}
