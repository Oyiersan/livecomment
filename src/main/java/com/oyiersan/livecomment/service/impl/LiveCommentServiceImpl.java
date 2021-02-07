package com.oyiersan.livecomment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oyiersan.livecomment.entity.LiveUser;
import com.oyiersan.livecomment.entity.UserComment;
import com.oyiersan.livecomment.entity.VideoLikeNum;
import com.oyiersan.livecomment.entity.dto.AddUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.DelUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.PageReqDTO;
import com.oyiersan.livecomment.entity.dto.TopUserCommentDTO;
import com.oyiersan.livecomment.entity.vo.UserCommentTopVO;
import com.oyiersan.livecomment.entity.vo.UserCommentVO;
import com.oyiersan.livecomment.mapper.LiveUserMapper;
import com.oyiersan.livecomment.mapper.UserCommentMapper;
import com.oyiersan.livecomment.mapper.VideoLikeNumMapper;
import com.oyiersan.livecomment.service.LiveCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LiveCommentServiceImpl implements LiveCommentService {

    @Autowired
    private LiveUserMapper liveUserMapper;

    @Autowired
    private UserCommentMapper userCommentMapper;

    @Autowired
    private VideoLikeNumMapper videoLikeNumMapper;

    private int videoLikeNum;

    @Override
    @Transactional
    public void addUserComment(AddUserCommentDTO dto) {
        log.info("addUserComment start dto {}", dto);
        LiveUser liveUser = liveUserMapper.selectOne(Wrappers.<LiveUser>lambdaQuery().eq(LiveUser::getCode, dto.getUserCode()));
        if (liveUser == null) {
            liveUser = new LiveUser();
            liveUser.setCode(dto.getUserCode());
            liveUser.setAvatar(dto.getAvatar());
            liveUser.setName(dto.getUserName());
            liveUserMapper.insert(liveUser);
        }
        UserComment userComment = new UserComment();
        userComment.setComment(dto.getComment());
        userComment.setUserId(liveUser.getId());
        userCommentMapper.insert(userComment);
        log.info("addUserComment end  {}", dto);
    }

    @Override
    public void delUserComment(DelUserCommentDTO dto) {
        log.info("delUserComment start {}", dto);
        userCommentMapper.deleteById(dto.getCommentId());
        log.info("delUserComment start {}", dto);
    }

    @Override
    public PageInfo<UserCommentVO> pageUserComment(PageReqDTO dto) {
        log.info("pageUserComment start dto {}", dto);
        PageInfo<UserComment> userCommentPage = PageHelper.startPage(dto.getPageNo(), dto.getPageSize()).doSelectPageInfo(() -> {
            userCommentMapper.selectList(Wrappers.<UserComment>lambdaQuery().orderByDesc(UserComment::getId));
        });
        List<UserComment> list = userCommentPage.getList();
        UserCommentVO userCommentVO = new UserCommentVO();

        List<UserCommentVO> voList = new ArrayList<>();
        PageInfo<UserCommentVO> voPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(userCommentPage, voPageInfo);
        voPageInfo.setList(voList);
        if (list != null && !list.isEmpty()) {
            list.forEach(userComment -> {
                LiveUser liveUser = liveUserMapper.selectById(userComment.getUserId());
                userCommentVO.setUserId(userComment.getUserId());
                userCommentVO.setUserName(liveUser.getName());
                userCommentVO.setAvatar(liveUser.getAvatar());
                userCommentVO.setCommentId(userComment.getId());
                userCommentVO.setComment(userComment.getComment());
                userCommentVO.setCommentDateTime(userComment.getCreateTime());
                voList.add(userCommentVO);
            });
        }
        log.info("pageUserComment voPageInfo {}", voPageInfo);
        return voPageInfo;
    }

    @Override
    public PageInfo<UserCommentTopVO>  topUserComment(TopUserCommentDTO dto) {
        PageInfo<UserCommentTopVO> userCommentTopVOPageInfo = PageHelper.startPage(dto.getPageNo(), dto.getPageSize()).doSelectPageInfo(() -> userCommentMapper.topCommentList("2021-02-04"));
//        List<UserCommentTopVO> list = userCommentTopVOPageInfo.getList();
//        List<UserCommentTopVO> userCommentTopVOS = userCommentMapper.topCommentList("2021-02-04");
        return userCommentTopVOPageInfo;
    }

    @Override
    public void likeComment(DelUserCommentDTO dto) {
        UserComment userComment = userCommentMapper.selectById(dto.getCommentId());
        if (userComment == null) {
            return;
        }
        UserComment userCommentUpdate = new UserComment();
        userCommentUpdate.setId(dto.getCommentId());
        userCommentUpdate.setLikeIt(Optional.ofNullable(userComment.getLikeIt()).orElse(0L) + 1);
        userCommentMapper.updateById(userCommentUpdate);
    }

    @Override
    public int likeItVideo() {
        initVideNum();
        videoLikeNum++;
        if (videoLikeNum % 10 ==0) {
            VideoLikeNum entity = new VideoLikeNum();
            entity.setLikeNum(videoLikeNum);
            videoLikeNumMapper.insert(entity);
        }
        return videoLikeNum;
    }

    @Override
    public int sumVideoLikeIt() {
        initVideNum();
        return videoLikeNum;
    }

    private void initVideNum() {
        if (videoLikeNum == 0) {
            PageInfo<VideoLikeNum> videoLikeNums = PageHelper.startPage(1, 1).doSelectPageInfo(() -> {
                videoLikeNumMapper.selectList(Wrappers.<VideoLikeNum>lambdaQuery().orderByDesc(VideoLikeNum::getId));
            });

            List<VideoLikeNum> result = videoLikeNums.getList();
            if (!result.isEmpty()) {
                videoLikeNum = result.get(0).getLikeNum();
            }
        }
    }

//    @PostConstruct
//    public void likeItVideoPostConstruct() {
////        PageInfo<VideoLikeNum> videoLikeNums = PageHelper.startPage(1, 3)
////                .doSelectPageInfo(() -> videoLikeNumMapper.selectList(Wrappers.<VideoLikeNum>lambdaQuery().orderByDesc(VideoLikeNum::getId)));
//
//        PageInfo<VideoLikeNum> videoLikeNums = PageHelper.startPage(1, 10).doSelectPageInfo(() -> {
//            videoLikeNumMapper.selectList(Wrappers.<VideoLikeNum>lambdaQuery().orderByDesc(VideoLikeNum::getId));
//        });
//
//        List<VideoLikeNum> result = videoLikeNums.getList();
//        if (!result.isEmpty()) {
//            videoLikeNum = result.get(0).getLikeNum();
//        }
//    }

    @PreDestroy
    public void likeItVideoPreDestroy() {
        VideoLikeNum entity = new VideoLikeNum();
        entity.setLikeNum(videoLikeNum);
        videoLikeNumMapper.insert(entity);
    }
}
