package com.example.demo.mapper.user;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	
	public List<Map<String,Object>> selectList();
	
	public int addUser(Map<String, Object> inParam);

	public int deleteUser(Map<String, Object> inParam);

}
