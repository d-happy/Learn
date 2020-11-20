package com.kh.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.ConnectionManager;
import com.kh.dao.MemberDao;
import com.kh.dao.MemoDao;
import com.kh.dao.PointDao;
import com.kh.domain.MemberVo;
import com.kh.domain.MemoVo;
import com.kh.domain.PointVo;

public class SendMessageService implements IService {
	
	private MemberDao memberDao = MemberDao.getInstance();
	private MemoDao memoDao = MemoDao.getInstance();
	private PointDao pointDao = PointDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String m_id = request.getParameter("m_id"); // 쪽지 받는 receiver_id
		String memo = request.getParameter("memo");
		System.out.println("m_id :" + m_id);
		System.out.println("memo :" + memo);
		
		HttpSession session = request.getSession();
		MemberVo loginUser = (MemberVo)session.getAttribute("memberVo");
		String sender_id = loginUser.getM_id(); // 쪽지 쓰는 sender_id
		
		// DB 작업
		// transaction
		// @@@.setConnection(ConnectionManager.getConnection());
		Connection conn = ConnectionManager.getConnection();
		memoDao.setConnection(conn);
		pointDao.setConnection(conn);
		memberDao.setConnection(conn);
		try {
			conn.setAutoCommit(false);
			
			MemoVo memoVo = new MemoVo();
			memoVo.setMemo_content(memo);
			memoVo.setReceiver_id(m_id);
			memoVo.setSender_id(sender_id);
			
			PointVo pointVo = new PointVo();
			pointVo.setM_id(sender_id);
			// ORA-02291: integrity constraint (MODEL2.SYS_C007189) violated - parent key not found
//			pointVo.setM_id("user1001"); // test
			pointVo.setPoint_code(1001);
			pointVo.setPoint_score(10);
			
			System.out.println(memoVo.toString());
			System.out.println(pointVo.toString());
			
			memoDao.insertMemo(memoVo);
			pointDao.insertPoint(pointVo);
			memberDao.updatePoint(sender_id, 10); // 보낸 사람 포인트+10
			
			// session에 저장된 memberVo 정보는, 로그인 당시의 tbl_member라서
			// 로그인 후에 바뀐 point 정보는 모름
			// memberDao.updatePoint(sender_id, 10); -> memberVo 변경
			// loginUser.setM_point(loginUser.getM_point() + 10); 
			// -> 변경된 point를 session에 저장된 memberVo에도 적용되게 함
			loginUser.setM_point(loginUser.getM_point() + 10);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			ConnectionManager.close(conn);
		}
		
		// 변경된 point 보내서 새로고침 없이 바로바로 바뀜
		request.setAttribute("data", loginUser.getM_point()); 
		return "data"; // 화면 필요 없는 건 다 여기다??
	}

} //SendMessageService
