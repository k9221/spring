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

import com.example.test1.dao.UserService;
import com.google.gson.Gson;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/join.do") 
    public String join(Model model) throws Exception{
		
        return "/join";
    }
	
	@RequestMapping("/login.do") 
    public String login(Model model) throws Exception{
		
        return "/login";
    }
	
	@RequestMapping("/user-list.do") 
    public String userList(Model model) throws Exception{
		
        return "/user-list";
    }
	
	@RequestMapping("/user-view.do") 
    public String userView(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println("site" + map);		// request 객체에 담겨서 보드뷰에 보내준다		// ㄴ 파라미터로 받고 싶으면 RequestParam을 사용							
		request.setAttribute("userId", map.get("userId"));
		return "/user-view";
    }
	@RequestMapping("/user-insert.do") 
    public String userInsert(Model model) throws Exception{
		
        return "/user-insert";
    }
	
	
	@RequestMapping(value = "/userIdCheck.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userIdCheck(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println("ttt" + map);
		resultMap = userService.searchUserLogin(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/user-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = userService.searchUserList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/board-list2.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String boardList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = userService.searchBoardList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/user-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteUserList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = userService.removeUserList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/user-view.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userView(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
								// request 객체에 담겨서 보드뷰에 보내준다		// ㄴ 파라미터로 받고 싶으면 RequestParam을 사용							
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = userService.searchUserInfo(map);
		
		return new Gson().toJson(resultMap);
	
	}
	
	@RequestMapping(value = "/user-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String user_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = userService.addUser(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/login.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login_user(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println("ss" + map);
		resultMap = userService.searchUserLogin(map);
		
		return new Gson().toJson(resultMap);
	}
}
