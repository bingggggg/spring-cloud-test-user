package com.trans.app.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.trans.app.domain.User;
import com.trans.app.domain.UserRepository;
import com.trans.app.dto.UserDto;
import com.trans.app.dto.UserPageDto;
import com.trans.app.service.UserService;
import com.trans.app.util.ConverterUtil;
import com.trans.app.util.MapStatusUtil;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	@Transactional
	public Map<String, String> save(UserDto u) {
		try {
			User user = ConverterUtil.convert(new User(), new UserDto(), u);
			System.out.println("user:>>>>>>>>>>>>" + user);
			userRepo.save(user);
			return MapStatusUtil.getSuccess("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return MapStatusUtil.getError("保存失败！");
		}
	}

	@Override
	@Transactional
	public Map<String, String> modify(UserDto u) {
		System.out.println(u);
		try {
			Optional<User> optional = userRepo.findOne((r, q, c) -> c.equal(r.get("userCode"), u.getUserCode()));
			if (optional.isPresent()) {
				User user = optional.get();
				System.out.println("user///////<>>>>>>>>>>>>>" + user);
				// user.setUserCode(u.getUserCode());
				user.setUserEmail(u.getUserEmail());
				user.setUserIdCode(u.getUserIdCode());
				user.setUserIdType(u.getUserIdType());
				user.setUserName(u.getUserName());
				user.setUserPassword(u.getUserPassword());
				user.setUserPhone(u.getUserPhone());
				userRepo.save(user);
			}
			return MapStatusUtil.getSuccess("修改成功");
		} catch (Exception e) {
			return MapStatusUtil.getError("修改失败");
		}
	}

	@Override
	@Transactional
	public Map<String, String> delete(UserDto u) {

		try {
			Optional<User> optional = userRepo.findOne((r, q, c) -> c.equal(r.get("userCode"), u.getUserCode()));
		if (optional.isPresent()) {
			userRepo.delete(optional.get());
		}
			return MapStatusUtil.getSuccess("删除成功");
		} catch (Exception e) {
			return MapStatusUtil.getError("删除失败");
		}
	}

	@Override
	public UserPageDto findAll(UserDto u) {
		int pageNumber = 0;
		if (u.getPage() != 0) {
			pageNumber = u.getPage() - 1;
		}

		PageRequest page = PageRequest.of(pageNumber, u.getLimit());
		Page<User> p = userRepo.findAll((r, q, c) -> c.and(
				u.getUserCode() != null && !u.getUserCode().equals("") ? c.equal(r.get("userCode"), u.getUserCode())
						: c.conjunction(),
				u.getUserIdCode() != null && !u.getUserIdCode().equals("")
						? c.equal(r.get("userIdCode"), u.getUserIdCode()) : c.conjunction(),
				u.getUserIdType() != null && !u.getUserIdType().equals("")
						? c.equal(r.get("userIdType"), u.getUserIdType()) : c.conjunction(),
				u.getUserName() != null && !u.getUserName().equals("") ? c.equal(r.get("userName"), u.getUserName())
						: c.conjunction()),
				page);
		List<UserDto> list = ConverterUtil.convertList(new UserDto(), new User(), p.getContent());
		return new UserPageDto(p.getTotalElements(), list);
	}

	@Override
	public UserDto findOne(UserDto u) {
		Optional<User> optional = userRepo.findOne((r, q, c) -> c.equal(r.get("userCode"), u.getUserCode()));
		if (optional.isPresent()) {
			return ConverterUtil.convert(new UserDto(), new User(), optional.get());
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> findAll = userRepo.findAll();
		return findAll;
	}

}
