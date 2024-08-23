package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.EmpMapper;
import com.example.test1.model.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	EmpMapper EmpMapper;
	
	@Override
	public List<Emp> searchEmpList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return EmpMapper.selectEmpList(map);
	}
	

}
