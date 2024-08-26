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

import com.example.test1.dao.StudentService;
import com.example.test1.model.Student;
import com.google.gson.Gson;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student.do") //do로 끝날경우 jsp와 상호작용 dox로 끝날 경우 db와 연결
    public String main(Model model) throws Exception{

        return "/student-list"; // student.do로 들어가면 /student-list를 실행
    }
	
	@RequestMapping("/test.do")  //자바 문법이기에 메소드명(함수)을 다르게 해준다. 하지만 오버로딩을 하면 동일한 이름을 가질 수도 있다.
    public String test(Model model) throws Exception{

        return "/test";
    }
	
	@RequestMapping("/subject.do")  //자바 문법이기에 메소드명(함수)을 다르게 해준다. 하지만 오버로딩을 하면 동일한 이름을 가질 수도 있다.
    public String subject(Model model) throws Exception{

        return "/subject-list";
    }
	
	@RequestMapping(value = "/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBbsList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Student> list = studentService.searchStudentList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/emp.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String stu2(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = studentService.searchStuNo(map);
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
	@RequestMapping(value = "/subject-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sub_list(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = studentService.searchSubject();
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
}




