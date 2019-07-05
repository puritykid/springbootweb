package com.example.demo.service;

import java.util.Map;


public interface UserService {
	
	public Map<String,Object> queryList(Map<String, Object> inParam);
	
	public void addUser(Map<String, Object> inParam);
	
	public void deleteUser(Map<String, Object> inParam);

}
