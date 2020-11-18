package com.kh.domain;

public class MemberVo {

	private String m_id;
	private String m_pw;
	private String m_name;
	private int m_point;

	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	
	@Override
	public String toString() {
		return "MemberVo [m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + ", m_point=" + m_point + "]";
	}
	
} //MemberVo
