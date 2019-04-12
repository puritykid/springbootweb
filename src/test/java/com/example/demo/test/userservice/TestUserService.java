package com.example.demo.test.userservice;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.SpringbootCastTest;
import com.example.demo.service.UserService;

public class TestUserService extends SpringbootCastTest {
	
	private static Map<String, Object> inParam11 = new HashMap<String, Object>();
	private static Map<String, Object> inParam21 = new HashMap<String, Object>();
 	
	@Autowired
	UserService userService;
	
	
	
	@Before
	public void setUp() {
		inParam11.put("name","李兆杰" + Math.random()*10);
		inParam11.put("age",22);
		inParam11.put("birthday","2011-12-13");
		inParam11.put("phone","12345678900");
		
		inParam21.put("name","李兆杰" + Math.random()*10);
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void testQueryList() {
		try {
			Map<String, Object> resultMap = userService.queryList();
			String retCode = (String) resultMap.get("retCode");
			String retMsg = (String) resultMap.get("retMsg");
			List<Map<String,Object>> dataList = (List<Map<String, Object>>) resultMap.get("data");
			Map<String, Object> dataMap = dataList.get(0);
			String name = (String) dataMap.get("name");
			Integer age = (Integer) dataMap.get("age");
			String birthday = (String) dataMap.get("birthday");
			String phone = (String) dataMap.get("phone");
			
			Assert.assertEquals("0", retCode);
			Assert.assertEquals("查询成功！", retMsg);
			Assert.assertEquals("陈晓军", name);
			Assert.assertEquals("28", String.valueOf(age));
			Assert.assertEquals("1990-07-12", birthday);
			Assert.assertEquals("18354222887", phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 事物回滚
	@Transactional
	@Rollback(true)
	@Test
	public void testAddUser() {
		try {
				Map<String, Object> resultMap = userService.addUser(inParam11);
				String retCode = (String) resultMap.get("retCode");
				String retMsg = (String) resultMap.get("retMsg");
				
				Assert.assertEquals("0", retCode);
				Assert.assertEquals("新增成功！", retMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUser() {
		try {
			Map<String, Object> resultMap = userService.deleteUser(inParam21);
			String retCode = (String) resultMap.get("retCode");
			String retMsg = (String) resultMap.get("retMsg");
			
			Assert.assertEquals("0", retCode);
			Assert.assertEquals("删除成功！", retMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
