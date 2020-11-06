package free.board;

import java.sql.Timestamp;

public class CommentVo {
	private int c_no;
	private String c_content;
	private String m_id;
	private Timestamp c_date;
	private int b_no;
	
	
	public CommentVo() {
		super();
	}

	public CommentVo(int c_no, String c_content, String m_id, Timestamp c_date, int b_no) {
		super();
		this.c_no = c_no;
		this.c_content = c_content;
		this.m_id = m_id;
		this.c_date = c_date;
		this.b_no = b_no;
	}



	public int getC_no() {
		return c_no;
	}


	public void setC_no(int c_no) {
		this.c_no = c_no;
	}


	public String getC_content() {
		return c_content;
	}


	public void setC_content(String c_content) {
		this.c_content = c_content;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public Timestamp getC_date() {
		return c_date;
	}


	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}


	public int getB_no() {
		return b_no;
	}


	public void setB_no(int b_no) {
		this.b_no = b_no;
	}


	@Override
	public String toString() {
		return "CommentVo [c_no=" + c_no + ", c_content=" + c_content + ", m_id=" + m_id + ", c_date=" + c_date
				+ ", b_no=" + b_no + "]";
	}
	
}//CommentVo
