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
	public Map<String, Object> queryList() {
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
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Map<String, Object> addUser(Map<String, Object> inParam) {
		Map<String, Object> outMap = new HashMap<String, Object>();
		try {
			userMapper.addUser(inParam);
			outMap.put("retCode", "0");
			outMap.put("retMsg", "新增成功！");
		} catch (Exception e) {
			e.printStackTrace();
			outMap.put("retCode", "0");
			outMap.put("retMsg", "新增失败！");
		}
		
		return outMap;
	}
	@Override
	public Map<String, Object> deleteUser(Map<String, Object> inParam) {
		Map<String, Object> outMap = new HashMap<String, Object>();
		try {
			userMapper.deleteUser(inParam);
			outMap.put("retCode", "0");
			outMap.put("retMsg", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			outMap.put("retCode", "0");
			outMap.put("retMsg", "删除失败！");
		}
		return outMap;
	}

}
