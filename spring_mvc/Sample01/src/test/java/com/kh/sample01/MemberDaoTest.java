package com.kh.sample01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.MemberDao;
import com.kh.sample01.dao.PointDao;
import com.kh.sample01.domain.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {

	@Inject
	private MemberDao memberDao; // 
	
	@Test
	public void testGetTime() throws Exception {
		memberDao.getTime();
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setUser_id("user01");
		memberVo.setUser_pw("1234");
		memberVo.setUser_email("user01@email.com");
		memberVo.setUser_name("유저1");
		memberDao.insertMember(memberVo);
	}
	
	@Test
	public void testSelectMember() throws Exception {
		MemberVo memberVo = memberDao.selectMember("user01");
		System.out.println("memberVo :" + memberVo);
	}
	
	@Test
	public void testLogin() throws Exception {
		MemberVo memberVo = memberDao.login("user01", "1234");
		System.out.println("memberVo :" + memberVo);
	}
	
	@Test 
	public void testMemberList() throws Exception {
		List<MemberVo> list = memberDao.memberList();
		System.out.println("list :" + list);
	}
	
	@Test
	public void testUpdatePoint() throws Exception {
		memberDao.updatePoint("user01", PointDao.SEND_MESSAGE_POINT);
	}
	
} //MemberDaoTest
