package com.example.test1.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.EmpService;
import com.example.test1.model.Emp;
import com.google.gson.Gson;

@Controller
public class EmpController {
	
	@Autowired
	EmpService EmpService;
	
	@RequestMapping("/emp.do") //내가 들어가는 사이트 주소
    public String main(Model model) throws Exception{

        return "/emp-list"; // emp.do의 사이트로 이동할 경우 emp-list를 실행
    }
	
	
	
	@RequestMapping(value = "/empList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchEmpList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Emp> list = EmpService.searchEmpList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}
	

}




