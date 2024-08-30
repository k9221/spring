package com.example.test1.model;

import lombok.Data;

@Data
public class Board {
	//tbl_board 테이블
	private int boardNo;
	private String title;
	private String contents;
	private String userId;
	private int hit;
	private String category;
	private String favorite;
	private String tag1;
	private String tag2;
	private String noticeYn;
	private String cdateTime;
	private String udateTime;
	
	//tbl_user 테이블
	private String pwd;
	private String userName;
	private String eMail;
	private String phone;
	private String gender;
	
	public String getUserId() {
		return userId;
	}


	
}
