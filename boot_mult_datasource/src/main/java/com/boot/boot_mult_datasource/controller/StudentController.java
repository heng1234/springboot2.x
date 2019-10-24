package com.boot.boot_mult_datasource.controller;

import com.boot.boot_mult_datasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("querystudentsfromoracle")
	public List<Map<String, Object>> queryStudentsFromOracle(){
		return this.studentService.getAllStudentsFromOralce();
	}
	
	@RequestMapping("querystudentsfrommysql")
	public List<Map<String, Object>> queryStudentsFromMysql(){
		return this.studentService.getAllStudentsFromMysql();
	}
}
