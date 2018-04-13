package com.trans.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trans.app.dto.UserDto;
import com.trans.app.dto.UserPageDto;
import com.trans.app.service.UserService;

@Controller
@RequestMapping("user")
public class UserContorller {
	UserService uService;

	public UserContorller(UserService uService) {
		this.uService = uService;
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping("/view/list")
	public String list() {
		return "index";
	}

	/**
	 * 首页表格数据
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/rest/list")
	@ResponseBody
	public UserPageDto list(UserDto u) {
		return uService.findAll(u);
	}

	@RequestMapping("/rest/list1")
	public String list1(Model model) {
		model.addAttribute("data", uService.findAll());
		return "index2";
	}

	/**
	 * 新增首页
	 * 
	 * @return
	 */
	@RequestMapping("/view/save")
	public String save() {
		return "useradd";
	}
	/**
	 * 保存（新增）
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/rest/save")
	@ResponseBody
	public Map<String, String> save(UserDto u) {

		u.setUserCode(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		System.out.println(u);
		return uService.save(u);
	}

	/**
	 * 修改首页
	 * 
	 * @return
	 */
	@RequestMapping("/view/modify")
	public String modify(String userCode, Model model) {
		UserDto u = new UserDto();
		u.setUserCode(userCode);
		model.addAttribute("data", uService.findOne(u));
		return "modify";
	}

	/**
	 * 修改
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/rest/modify")
	@ResponseBody
	public Map<String, String> modify(UserDto u) {
		return uService.modify(u);

	}

	/**
	 * 删除
	 * 
	 * @param us
	 * @return
	 */
	@RequestMapping("/rest/delete")
	@ResponseBody
	public Map<String, String> delete(String userCode) {
		UserDto u = new UserDto();
		u.setUserCode(userCode);
		return uService.delete(u);

	}
}
