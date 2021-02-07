package com.oyiersan.livecomment.service;

import com.github.pagehelper.PageInfo;
import com.oyiersan.livecomment.entity.dto.AddUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.DelUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.PageReqDTO;
import com.oyiersan.livecomment.entity.dto.TopUserCommentDTO;
import com.oyiersan.livecomment.entity.vo.UserCommentTopVO;
import com.oyiersan.livecomment.entity.vo.UserCommentVO;

public interface LiveCommentService {

    /**
     * 添加用户评论
     */
    void addUserComment(AddUserCommentDTO dto);

    /**
     * 删除用户评论
     * @param dto
     */
    void delUserComment(DelUserCommentDTO dto);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageInfo<UserCommentVO> pageUserComment(PageReqDTO dto);

    /**
     * 统计top榜单
     * @returnS
     * @param commentDate
     */
    PageInfo<UserCommentTopVO> topUserComment(TopUserCommentDTO commentDate);

    /**
     * 评论点赞
     * @param dto
     */
    void likeComment(DelUserCommentDTO dto);

    /**
     * 视频点赞
     */
    int likeItVideo();

    /**
     * 统计视频点赞
     * @return
     */
    int sumVideoLikeIt();
}
