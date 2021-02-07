package com.oyiersan.livecomment.controller;


import com.github.pagehelper.PageInfo;
import com.oyiersan.livecomment.entity.dto.AddUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.DelUserCommentDTO;
import com.oyiersan.livecomment.entity.dto.PageReqDTO;
import com.oyiersan.livecomment.entity.dto.TopUserCommentDTO;
import com.oyiersan.livecomment.entity.model.ResponseModel;
import com.oyiersan.livecomment.entity.vo.UserCommentTopVO;
import com.oyiersan.livecomment.entity.vo.UserCommentVO;
import com.oyiersan.livecomment.entity.vo.UserTopListVO;
import com.oyiersan.livecomment.service.LiveCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/basic/live")
@Slf4j
@Api(value = "userComment", tags = "用户评论")
public class UserCommentController {

    @Autowired
    private LiveCommentService liveCommentService;

    @PostMapping("/addComment")
    @ApiOperation(value = "添加用户评论")
    public ResponseModel<String> addUserComment(@RequestBody AddUserCommentDTO dto) {
        liveCommentService.addUserComment(dto);
        return ResponseModel.success("ok");
    }

    @PostMapping("/delComment")
    @ApiOperation(value = "删除用户评论")
    public ResponseModel<String> delUserComment(@RequestBody DelUserCommentDTO dto) {
        liveCommentService.delUserComment(dto);
        return ResponseModel.success("ok");
    }

    @PostMapping("/likeComment")
    @ApiOperation(value = "评论点赞")
    public ResponseModel<String> likeComment(@RequestBody DelUserCommentDTO dto) {
        liveCommentService.likeComment(dto);
        return ResponseModel.success("ok");
    }

    @PostMapping("/page")
    @ApiOperation(value = "用户评论列表查询")
    public ResponseModel<PageInfo<UserCommentVO>> pageUserComment(@Valid @RequestBody PageReqDTO dto) {
        return ResponseModel.success(liveCommentService.pageUserComment(dto));
    }

    @PostMapping("/top")
    @ApiOperation(value = "top榜单")
    public ResponseModel<PageInfo<UserCommentTopVO>> topUserComment(@Valid @RequestBody TopUserCommentDTO dto) {
        return ResponseModel.success(liveCommentService.topUserComment(dto));
    }

    @PostMapping("/likeItVideo")
    @ApiOperation(value = "视频点赞")
    public ResponseModel<Integer> likeItVideo() {
        return ResponseModel.success(liveCommentService.likeItVideo());
    }

    @PostMapping("/sumLikeItVideo")
    @ApiOperation(value = "统计视频点赞")
    public ResponseModel<Integer> sumLikeItVideo() {
        return ResponseModel.success(liveCommentService.sumVideoLikeIt());
    }



}

