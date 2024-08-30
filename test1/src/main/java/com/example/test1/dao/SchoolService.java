package com.example.test1.dao;

import java.util.HashMap;

public interface SchoolService {
	// 게시글 목록
	HashMap<String,Object> searchSchoolList(HashMap<String,Object> map);
	// 학생정보 상세보기
	HashMap<String, Object> searchSchoolInfo(HashMap<String, Object> map);
	// 학생정보 삭제하기
	HashMap<String,Object> removeSchool(HashMap<String,Object> map);
	// 학생정보 등록하기
	HashMap<String,Object> addSchool(HashMap<String,Object> map);

}
