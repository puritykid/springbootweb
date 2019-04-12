package com.example.demo.mapper.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

public interface DemoMapper {
	
	public List<Map<String,Object>> selectList();

}
