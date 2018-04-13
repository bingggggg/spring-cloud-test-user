package com.trans.app.dto;

import java.util.List;

public class UserPageDto {
	private Long count = 0L;

	private String msg = "";

	private String code = "0";
	
	private List<UserDto> data;

	public UserPageDto(Long count, List<UserDto> data) {
		this.count = count;
		this.data = data;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserDto> getData() {
		return data;
	}

	public void setData(List<UserDto> data) {
		this.data = data;
	}


}
