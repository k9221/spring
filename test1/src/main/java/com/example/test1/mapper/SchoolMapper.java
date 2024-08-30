package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Board;
import com.example.test1.model.School;

@Mapper
public interface SchoolMapper {
	//학생 리스트 나타내기
	List<School> selectSchoolList(HashMap<String, Object> map);
	//학생정보 상세보기
	School selectUserInfo(HashMap<String, Object> map);
	//학생정보 삭제하기
	void deleteSchool(HashMap<String, Object> map);
	//학생 정보 등록
	void insertSchool(HashMap<String, Object> map);
	
}