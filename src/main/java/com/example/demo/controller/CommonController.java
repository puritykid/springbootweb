package com.example.demo.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.util.CommonUtil;
import com.example.demo.util.SpringContextUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CommonController", tags = "服务入口")
@RestController
public class CommonController {
	
	
	@ApiOperation("服务统一调用入口")
	@SuppressWarnings("unchecked")
	@RequestMapping("/callservice/{service}/{method}")
	public Map<String, Object> callService(@PathVariable("service")String serviceName,@PathVariable("method")String methodName,String inputJson){
		Map<String, Object> outParam = new HashMap<String, Object>();
		if (CommonUtil.isObjectNull(serviceName)) {
			outParam.put("code", "1");
			outParam.put("msg", "找不到服务！");
			return outParam;
		}
		
		if (CommonUtil.isObjectNull(methodName)) {
			outParam.put("code", "1");
			outParam.put("msg", "找不到方法！");
		}
		
		try {
			
			Map<String,Object> inParam = JSON.parseObject(inputJson, Map.class);
			Object service = SpringContextUtil.getBean(serviceName);
			Method method = service.getClass().getMethod(methodName, Map.class);
			outParam = (Map<String, Object>) method.invoke(service, inParam);
			
		} catch (Exception e) {
			outParam.put("code", "1"); 
			outParam.put("msg", "调用服务异常！");
			return outParam;
		}
		
		return outParam;
	}
	
	
}
