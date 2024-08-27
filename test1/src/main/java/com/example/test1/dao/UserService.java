package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import com.example.test1.model.Board;

public interface UserService {
	// 게시글 목록
	HashMap<String, Object> searchUserIdCheck(HashMap<String, Object> map);
}
