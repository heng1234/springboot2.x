package com.boot.boot_mult_datasource.mysql.mapper;

import java.util.List;
import java.util.Map;


public interface MysqlStudentMapper {
	List<Map<String, Object>> getAllStudents();
}
