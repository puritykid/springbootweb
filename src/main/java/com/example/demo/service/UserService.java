package com.example.demo.service;

import java.util.Map;

public interface UserService {
	
	public Map<String,Object> queryList();
	
	public Map<String, Object> addUser(Map<String, Object> inParam);
	
	public Map<String, Object> deleteUser(Map<String, Object> inParam);

}
