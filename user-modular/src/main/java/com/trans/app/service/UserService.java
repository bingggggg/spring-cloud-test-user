package com.trans.app.service;

import java.util.List;
import java.util.Map;

import com.trans.app.domain.User;
import com.trans.app.dto.UserDto;
import com.trans.app.dto.UserPageDto;

public interface UserService {

	/**
	 * 保存
	 * 
	 * @param u
	 *            对象
	 * @return true 200（false 500）
	 */
	public Map<String, String> save(UserDto u);

	/**
	 * 修改
	 * 
	 * @param u
	 *            对象
	 * @return true 200（false 500）
	 */
	public Map<String, String> modify(UserDto u);

	/**
	 * 删除
	 * 
	 * @param u
	 *            对象
	 * @return true 200（false 500）
	 */
	public Map<String, String> delete(UserDto u);


	/**
	 * 查询所有
	 * 
	 * @param u
	 *            dto对象
	 * @return page对象
	 */
	public UserPageDto findAll(UserDto u);

	/**
	 * 查询一条记录
	 * 
	 * @param u
	 *            对象
	 * @return 对象
	 */
	public UserDto findOne(UserDto u);

	public List<User> findAll();

}
