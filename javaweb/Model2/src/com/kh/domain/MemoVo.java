package com.kh.domain;

import java.sql.Timestamp;

public class MemoVo {
	
	private int memo_id;
	private String memo_content;
	private String sender_id;
	private String receiver_id;
	private Timestamp send_date;
	private Timestamp read_date;
	
	public int getMemo_id() {
		return memo_id;
	}
	public void setMemo_id(int memo_id) {
		this.memo_id = memo_id;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public Timestamp getSend_date() {
		return send_date;
	}
	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}
	public Timestamp getRead_date() {
		return read_date;
	}
	public void setRead_date(Timestamp read_date) {
		this.read_date = read_date;
	}

	@Override
	public String toString() {
		return "MemoVo [memo_id=" + memo_id + ", memo_content=" + memo_content + ", sender_id=" + sender_id
				+ ", receiver_id=" + receiver_id + ", send_date=" + send_date + ", read_date=" + read_date + "]";
	}
	
} //MemoVo
