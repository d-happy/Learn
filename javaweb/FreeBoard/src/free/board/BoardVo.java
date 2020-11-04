package free.board;

import java.sql.*;

public class BoardVo {
	private int b_no;
    private String b_title;
    private String b_content;
    private Timestamp b_date;
    private String m_id;
    private String b_ip;
    private int b_readcount;
    
	public BoardVo() {
		super();
	}

	public BoardVo(int b_no, String b_title, String b_content, Timestamp b_date, String m_id,
			String b_ip, int b_readcount) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = b_date;
		this.m_id = m_id;
		this.b_ip = b_ip;
		this.b_readcount = b_readcount;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Timestamp getB_date() {
		return b_date;
	}

	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getB_ip() {
		return b_ip;
	}

	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}

	public int getB_readcount() {
		return b_readcount;
	}

	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}

	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", b_date=" + b_date
				+ ", m_id=" + m_id + ", b_ip=" + b_ip + ", b_readcount=" + b_readcount + "]";
	}

}//BoardVo
