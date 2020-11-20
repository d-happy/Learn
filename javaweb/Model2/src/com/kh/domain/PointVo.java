package com.kh.domain;

import java.sql.Timestamp;

public class PointVo {

	private int point_no;
	private String m_id;
	private int point_code;
	private String point_name;
	private int point_score;
	private Timestamp point_date;
	
	public int getPoint_no() {
		return point_no;
	}
	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getPoint_code() {
		return point_code;
	}
	public void setPoint_code(int point_code) {
		this.point_code = point_code;
	}
	public String getPoint_name() {
		return point_name;
	}
	public void setPoint_name(String point_name) {
		this.point_name = point_name;
	}
	public int getPoint_score() {
		return point_score;
	}
	public void setPoint_score(int point_score) {
		this.point_score = point_score;
	}
	public Timestamp getPoint_date() {
		return point_date;
	}
	public void setPoint_date(Timestamp point_date) {
		this.point_date = point_date;
	}
	
	@Override
	public String toString() {
		return "PointVo [point_no=" + point_no + ", m_id=" + m_id + ", point_code=" + point_code + ", point_name="
				+ point_name + ", point_score=" + point_score + ", point_date=" + point_date + "]";
	}
	
} //PointVo
