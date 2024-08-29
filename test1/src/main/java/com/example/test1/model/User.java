package com.example.test1.model;

import lombok.Data;
@Data
public class User {
	private String userId;
	private String pwd;
	private String userName;
	private String eMail;
	private String phone;
	private String gender;
	
	private String boardNo;
	private String title;
	private String contents;
	private int hit;
	private String category;
	private String favorite;
	private String tag1;
	private String tag2;
	private String noticeYn;
	private String cdateTime;
	private String udateTime;
	public String getUserId() {
		return userId;
	}
	public String getPwd() {
		return pwd;
	}
	
	
	
}
