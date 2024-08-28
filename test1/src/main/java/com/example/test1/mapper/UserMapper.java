package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Board;
import com.example.test1.model.User;

@Mapper
public interface UserMapper {
	
	User selectUserIdCheck(HashMap<String, Object> map);
	
	List<User> selectUserList(HashMap<String, Object> map);
	
	List<User> selectBoardList(HashMap<String, Object> map);
	
	void deleteUserList(HashMap<String, Object> map);

	// 유저정복 상세조회
	User selectUserInfo(HashMap<String, Object> map);
	// 유저정보 등록
	void insertUser(HashMap<String, Object> map);
}
