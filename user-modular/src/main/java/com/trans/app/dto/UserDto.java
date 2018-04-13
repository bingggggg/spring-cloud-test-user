package com.trans.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class UserDto {

	@NonNull
	@Size(max = 30)
	private String userName;
	@NonNull
	@Size(max = 30)
	@Column(unique = true)
	private String userCode;
	@NonNull
	@Size(max = 30)
	private String userPassword;
	@NonNull
	@Size(max = 30)
	@Column(unique = true)
	private String userIdCode;
	@NonNull
	@Size(max = 30)
	private String userIdType;
	@NonNull
	@Size(max = 30)
	private String userPhone;
	@NonNull
	@Size(max = 30)
	private String userEmail;

	private int page;

	private int limit;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserIdCode() {
		return userIdCode;
	}

	public void setUserIdCode(String userIdCode) {
		this.userIdCode = userIdCode;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", userCode=" + userCode + ", userPassword=" + userPassword
				+ ", userIdCode=" + userIdCode + ", userIdType=" + userIdType + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + "]";
	}

}
