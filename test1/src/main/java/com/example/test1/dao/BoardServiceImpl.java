package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.BoardMapper;
import com.example.test1.model.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	BoardMapper BoardMapper;
	
	@Override
	public HashMap<String, Object> searchBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<Board> list = BoardMapper.selectBoardList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		
		return resultMap;
	}

	@Override
	public HashMap<String, Object> removeBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		
		try {
			BoardMapper.deleteBoard(map);
			resultMap.put("message", "삭제되었습니다");
		} catch (Exception e) {
			resultMap.put("fail", "예기치 못한 변수가 발생했습니다.");
			// TODO: handle exception
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			BoardMapper.insertBoard(map);
			resultMap.put("result", "success");
			resultMap.put("message", "등록되었습니다.");
		} catch (Exception e) {
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다.");
			// TODO: handle exception
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			BoardMapper.selectBoard(map);
			resultMap.put("result", "success");
			resultMap.put("message", "검색되었습니다.");
		} catch (Exception e) {
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다.");
			// TODO: handle exception
		}
		return resultMap;
	}


}
