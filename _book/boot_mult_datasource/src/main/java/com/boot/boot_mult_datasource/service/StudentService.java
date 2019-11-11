package com.boot.boot_mult_datasource.service;

import com.boot.boot_mult_datasource.mysql.mapper.MysqlStudentMapper;
import com.boot.boot_mult_datasource.oracle.mapper.OracleStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentService {
	@Autowired
	private OracleStudentMapper oracleStudentMapper;
	@Autowired
	private MysqlStudentMapper mysqlStudentMapper;
	
	public List<Map<String, Object>> getAllStudentsFromOralce() {
		return this.oracleStudentMapper.getAllStudents();
	}

	public List<Map<String, Object>> getAllStudentsFromMysql() {
		return this.mysqlStudentMapper.getAllStudents();
	}

}
