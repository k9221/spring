package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import com.example.test1.model.Student;
// dao의 역할 : 중계자 db로부터 데이터를 가져오고 다시 컨트롤러에 데이터를 전송하는 역할 + 가공의 역할까지 수행
public interface StudentService {
	// 게시글 조회
	List<Student> searchStudentList(HashMap<String, Object> map);
	
	Student searchQwer();
	
	HashMap<String, Object> searchStuNo(HashMap<String, Object> map);

	HashMap<String, Object> searchSubject();
	
	
	
	
}
