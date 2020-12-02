package com.kh.sample01;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.MessageDao;
import com.kh.sample01.dao.PointDao;
import com.kh.sample01.domain.MessageVo;
import com.kh.sample01.domain.PointVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PointDaoTest {

	@Inject
	private PointDao pointDao;
	
	@Test
	public void testInsertPoint() throws Exception {
		PointVo pointVo = new PointVo();
		pointVo.setUser_id("user01");
		pointVo.setPoint_code(PointDao.SEND_MESSAGE_CODE);
		pointVo.setPoint_score(PointDao.SEND_MESSAGE_POINT);
		pointDao.insertPoint(pointVo);
	}
	
}
