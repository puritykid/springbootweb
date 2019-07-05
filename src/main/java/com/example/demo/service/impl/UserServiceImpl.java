package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.user.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public Map<String, Object> queryList(Map<String, Object> inParam) {
		Map<String, Object> outMap = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = userMapper.selectList();
			outMap.put("data", list);
			outMap.put("retCode", "0");
			outMap.put("retMsg", "查询成功！");
		} catch (Exception e) {
				outMap.put("retCode", "1");
				outMap.put("retMsg", "查询失败！");
		}
		return outMap;
	}
	
	@Override
	public void addUser(Map<String, Object> inParam) {
			userMapper.addUser(inParam);
	}
	
	
	@Override
	public void deleteUser(Map<String, Object> inParam) {
		userMapper.deleteUser(inParam);
	}

}
