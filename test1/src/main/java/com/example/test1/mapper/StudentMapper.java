package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Student;

@Mapper
public interface StudentMapper {
	List<Student> selectStudentList();
	
	Student qwer(); // 하나만을 리턴 받을 경우에는 List가 아닌 타입하나만 정의해준다.
	
	Student studentJoin(HashMap<String, Object> map);
	
	List<Student> selectSubject();
}
