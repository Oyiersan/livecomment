package com.oyiersan.livecomment;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.oyiersan.livecomment.entity.LiveUser;
import com.oyiersan.livecomment.entity.UserComment;
import com.oyiersan.livecomment.mapper.LiveUserMapper;
import com.oyiersan.livecomment.mapper.UserCommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LivecommentApplicationTests {

	@Autowired
	private LiveUserMapper liveUserMapper;

	@Autowired
	private UserCommentMapper userCommentMapper;

	@Test
	void liveUserMapperTest() {
		List<LiveUser> liveUsers = liveUserMapper.selectList(Wrappers.<LiveUser>lambdaQuery());
		System.out.println("111111");
	}

	@Test
	void contextLoads() {
		List<UserComment> userComments = userCommentMapper.selectList(Wrappers.<UserComment>lambdaQuery());
		System.out.println("2222222");
	}

}
