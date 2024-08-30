package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.SchoolMapper;
import com.example.test1.model.School;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	SchoolMapper SchoolMapper;
	
	@Autowired // 세션 정보 
	HttpSession session;

	@Override
	public HashMap<String, Object> searchSchoolList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
		try {
			List<School> list = SchoolMapper.selectSchoolList(map);
			resultMap.put("list", list);
			resultMap.put("result", "success");
			resultMap.put("message", "검색되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		
		return resultMap;
	}




}
