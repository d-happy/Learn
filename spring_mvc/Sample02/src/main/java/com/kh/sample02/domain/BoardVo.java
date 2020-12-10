package com.kh.sample02.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class BoardVo {
	
	private int b_no;
	private String b_title;
	private String b_content;
	private String user_id;
	private Timestamp b_regdate;
	private int b_viewcnt;
	private int re_group;
	private int re_seq;
	private int re_level;
	private int comment_cnt;
	private int like_count;
	
	private String[] files;
	
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Timestamp b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_viewcnt() {
		return b_viewcnt;
	}
	public void setB_viewcnt(int b_viewcnt) {
		this.b_viewcnt = b_viewcnt;
	}
	public int getRe_group() {
		return re_group;
	}
	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", user_id=" + user_id
				+ ", b_regdate=" + b_regdate + ", b_viewcnt=" + b_viewcnt + ", re_group=" + re_group + ", re_seq="
				+ re_seq + ", re_level=" + re_level + ", comment_cnt=" + comment_cnt + ", like_count=" + like_count
				+ ", files=" + Arrays.toString(files) + "]";
	}
	
}
