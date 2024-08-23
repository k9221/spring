package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.StudentMapper;
import com.example.test1.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	StudentMapper studentMapper;
	
	@Override
	public List<Student> searchStudentList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentList(map);
	}

	@Override
	public Student searchQwer() {
		return studentMapper.qwer();
	}
	
	public HashMap<String, Object> searchStuNo(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			// db호출 데이터 
			// 결과(성공,실패), 메시지(성공메세지, 실패메세지)
			Student s = studentMapper.studentJoin(map);
			resultMap.put("stu", s);
			resultMap.put("result", "success");
			String msg 
				= s != null ? "조회했습니다!" : "학번을 확인하세요";
			
			resultMap.put("message", "조회했습니다.");
		} catch (Exception e) {
			resultMap.put("result", "fail");
			resultMap.put("message", "db조회 오류");
		}
		
		return resultMap ;
		
	}

}
