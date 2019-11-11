package com.boot.boot_log_aop.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysLog implements Serializable{

	private static final long serialVersionUID = -6309732882044872298L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户操作
	 */
	private String operation;
	/**
	 * 响应时间
	 */
	private Integer time;
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求参数
	 */
	private String params;
	/**
	 * Ip地址
	 */
	private String ip;
	/**
	 * 创建时间
	 */
	private Date createTime;

	
}
