package com.example.test1.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.SchoolService;
import com.google.gson.Gson;

@Controller
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
	//학생정보리스트 출력
	@RequestMapping("/school-stu.do") 
    public String school(Model model) throws Exception{
		
        return "/school-stu";
    }
	
	//학생정보 자세히 나타내기
	@RequestMapping("/school-view.do") 
    public String schoolView(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println("site" + map);		// request 객체에 담겨서 보드뷰에 보내준다		// ㄴ 파라미터로 받고 싶으면 RequestParam을 사용							
		request.setAttribute("stuNo", map.get("stuNo"));
		
		return "/school-view";
    }
	//게시글 등록하기
	@RequestMapping("/school-insert.do") 
    public String schoolInsert(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println(map);		// request 객체에 담겨서 보드뷰에 보내준다		// ㄴ 파라미터로 받고 싶으면 RequestParam을 사용							
		request.setAttribute("stuNo", map.get("stuNo"));
		
		return "/school-insert";
    }
	
	//학생 리스트 나타내기
	@RequestMapping(value = "/school-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = schoolService.searchSchoolList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	//학생정보 자세히 보기
	@RequestMapping(value = "/school-view.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String school_view(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = schoolService.searchSchoolInfo(map);
		
		return new Gson().toJson(resultMap);
	
	}
	
	//학생정보 삭제하기
	@RequestMapping(value = "/school-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = schoolService.removeSchool(map);
		
		return new Gson().toJson(resultMap);
	}
	
	//학생정보 등록
	@RequestMapping(value = "/school-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String school_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println("이거지" + map);
		resultMap = schoolService.addSchool(map);
		return new Gson().toJson(resultMap);
	}
	
	
	
}
