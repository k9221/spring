package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.SchoolMapper;
import com.example.test1.model.Board;
import com.example.test1.model.School;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	SchoolMapper schoolMapper;
	
	@Autowired // 세션 정보 
	HttpSession session;
	
	//학생정보리스트 출력
	@Override
	public HashMap<String, Object> searchSchoolList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
		try {
			List<School> list = schoolMapper.selectSchoolList(map);
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
	
	//학생정보 자세히보기
	@Override
	public HashMap<String, Object> searchSchoolInfo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println("이거임" + map);
		School info = schoolMapper.selectUserInfo(map);
		resultMap.put("info", info);
		resultMap.put("result", "success");
		
		return resultMap;
	}
	
	//학생정보 삭제하기
	@Override
	public HashMap<String, Object> removeSchool(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		try {
			schoolMapper.deleteSchool(map);
			resultMap.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		
		return resultMap;
	}
	
	//학생 정보 등록하기
	@Override
	public HashMap<String, Object> addSchool(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			schoolMapper.insertSchool(map);
			
			resultMap.put("result", "success");
			resultMap.put("message", "등록되었습니다.");
			session.getAttribute("sessionId");
			session.getAttribute("sessionEmail");
		
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		return resultMap;
	}


}
