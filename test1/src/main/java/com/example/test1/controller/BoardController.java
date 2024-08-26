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

import com.example.test1.dao.BoardService;
import com.example.test1.model.Board;
import com.google.gson.Gson;

@Controller
public class BoardController {
	@Autowired
	BoardService BoardService;
	
	// 게시글 목록 페이지
	@RequestMapping("/board-list.do") //내가 들어가는 사이트 주소
    public String boardList(Model model) throws Exception{

        return "/board-list"; // emp.do의 사이트로 이동할 경우 emp-list를 실행
    }
	
	// 게시글 작성
	@RequestMapping("/board-insert.do") //내가 들어가는 사이트 주소
    public String boardInsert(Model model) throws Exception{

        return "/board-insert"; // emp.do의 사이트로 이동할 경우 emp-list를 실행
    }
	
	
	@RequestMapping(value = "/board-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String boardList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = BoardService.searchBoardList(map);
		
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
	@RequestMapping(value = "/board-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = BoardService.removeBoard(map);
		
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
	@RequestMapping(value = "/board-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = BoardService.addBoard(map);
		
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
	@RequestMapping(value = "/searchBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = BoardService.searchBoard(map);
		
		return new Gson().toJson(resultMap); // gson의 형태로 돌려줌 (고정)
	}
	
	
	
}
