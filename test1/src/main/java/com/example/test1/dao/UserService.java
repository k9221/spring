package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import com.example.test1.model.Board;

public interface UserService {
	// 게시글 목록
	HashMap<String, Object> searchUserIdCheck(HashMap<String, Object> map);
	
	HashMap<String, Object> searchUserList(HashMap<String, Object> map);
	
	HashMap<String, Object> searchBoardList(HashMap<String, Object> map);
	
	HashMap<String, Object> removeUserList(HashMap<String, Object> map);
	
	HashMap<String, Object> searchUserInfo(HashMap<String, Object> map);
	
	HashMap<String,Object> addUser(HashMap<String,Object> map);
	
	HashMap<String,Object> searchUserLogin(HashMap<String,Object> map);
	
	
	
}
