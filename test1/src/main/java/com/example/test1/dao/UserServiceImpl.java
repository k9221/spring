package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.UserMapper;
import com.example.test1.model.Board;
import com.example.test1.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired // 내가 사용하지 않을 경우 자동 소멸됌. 또한 여러군대에서도 사용 가능하다.
	UserMapper userMapper;
	
	@Autowired // 세션 정보 
	HttpSession session;

	@Override
	public HashMap<String, Object> searchUserIdCheck(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
		try {
			User idCheck = userMapper.selectUserIdCheck(map);
			resultMap.put("info", idCheck);
			resultMap.put("result", "success");
			resultMap.put("message", "저장되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n 다시 시도해주세요.");
		}
		
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> searchUserList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
		try {
			System.out.println("dd" + map);
			List<User> list = userMapper.selectUserList(map);
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
	
	@Override
	public HashMap<String, Object> searchBoardList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			
		try {
			List<User> board = userMapper.selectBoardList(map);
			resultMap.put("boardList", board);
			resultMap.put("result", "success");
			resultMap.put("message", "검색되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> removeUserList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		try {
			userMapper.deleteUserList(map);
			resultMap.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n user.");
		}
		
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> searchUserInfo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		User user = userMapper.selectUserInfo(map);
		resultMap.put("user", user);
		resultMap.put("result", "success");
		
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addUser(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap =new HashMap<String, Object>();
		try {
			System.out.println("sss" + map);
			userMapper.insertUser(map);
			resultMap.put("result", "success");
			resultMap.put("message", "회원가입이완료되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "문제가 발생하였습니다, 다시 시도해 주세요");
		}
		return resultMap;
		
	}
	// JWT 방식도 있다.
	@Override
	public HashMap<String, Object> searchUserLogin(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			User user = userMapper.selectUserLogin(map);
			
			if(user == null) {
				resultMap.put("result", "fail");
				User idCheck = userMapper.selectUserIdCheck(map);
				System.out.println("map" + map);
				if(idCheck == null) {
					resultMap.put("message", "없는 아이디 입니다.");
				} else {
					resultMap.put("message", "비밀번호를 다시 확인해주세요");
				}
			} else { 
				resultMap.put("result", "success");
				resultMap.put("message", "로그인이 완료되었습니다.");
				session.setAttribute("sessionId", user.getUserId());
				session.setAttribute("sessionName", user.getUserName());
				session.setAttribute("sessionStatus", user.getStatus());
				session.setAttribute("sessionEmail", user.geteMail());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+ e); //이거좋다!!!!!!!!!!!
			resultMap.put("result", "fail");
			resultMap.put("message", "문제가 발생하였습니다, 다시 시도해 주세요");
		}
		return resultMap;
	}


}
