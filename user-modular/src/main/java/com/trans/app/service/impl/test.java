package com.trans.app.service.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.trans.app.domain.User;
import com.trans.app.dto.UserDto;
import com.trans.app.util.ConverterUtil;

public class test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Field[] fields1 = UserDto.class.getDeclaredFields();
		Constructor<UserDto> con1 = UserDto.class.getConstructor();
		UserDto userDto = con1.newInstance();

		List<User> li = new ArrayList<>();
		User u = new User();
		u.setUserCode("0000");
		u.setUserIdCode("3333");
		u.setUserEmail("email");
		u.setUserIdType("type");
		u.setUserName("userNam");
		u.setUserPassword("userPassword");
		u.setUserPhone("userPhone");
		// Field[] fields = User.class.getDeclaredFields();
		li.add(u);
		/*
		 * UserDto d = ConverterUtil.convert(new UserDto(), new User(), u);
		 * UserDto s = (UserDto) test(new UserDto(), new User(), u);
		 * System.out.println(d);
		 */
		List<UserDto> list = ConverterUtil.convertList(new UserDto(), new User(), li);
		list.forEach(o -> {
			System.out.println(o);
		});
		// System.out.println(convert);
		/*
		 * for (int i = 0; i < fields1.length; i++) { for (int j = 0; j <
		 * fields.length; j++) { if
		 * (fields1[i].getName().equals(fields[j].getName()) &&
		 * fields1[i].getType().equals(fields[j].getType())) {
		 * fields1[i].setAccessible(true); fields[j].setAccessible(true);
		 * System.out.println(fields[j].get(u)); fields1[i].set(userDto,
		 * fields[j].get(u)); } } } System.out.println(userDto);
		 */
	}

	public static <T, D> Object test(T t, D d, Object o) {

		Field[] fields = t.getClass().getDeclaredFields();
		Field[] field = d.getClass().getDeclaredFields();
		try {
			Constructor<? extends Object> con = t.getClass().getConstructor();
			Object obj = con.newInstance();
			for (int i = 0; i < fields.length; i++) {
				for (int j = 0; j < field.length; j++) {
					if (fields[i].getName().equals(field[j].getName())
							&& fields[i].getType().equals(field[j].getType())) {
						fields[i].setAccessible(true);
						field[j].setAccessible(true);
						// System.out.println(field[j].get(o));
						fields[i].set(obj, field[j].get(o));
					}
				}
			}
			return obj;
		} catch (Exception e) {
			System.out.println("转换异常");
			e.printStackTrace();
			return null;
		}

	}

	public static <T, D> List<T> convert(Class<T> t, Class<D> d, List<Object> list) {

		Field[] fields = t.getClass().getDeclaredFields();
		Field[] field = d.getClass().getDeclaredFields();
		List<T> lists = new ArrayList<>();
		try {

			for (int k = 0; k < list.size(); k++) {

				Constructor<? extends Object> con = t.getClass().getConstructor();
				Object obj = con.newInstance();
				for (int i = 0; i < fields.length; i++) {
					for (int j = 0; j < field.length; j++) {
						if (fields[i].getName().equals(field[j].getName())
								&& fields[i].getType().equals(field[j].getType())) {
							fields[i].setAccessible(true);
							fields[j].setAccessible(true);
							System.out.println(field[j].get(list.get(k)));
							fields[i].set(obj, field[j].get(list.get(k)));
						}
					}
				}
				lists.add((T) obj);
			}
			return lists;
		} catch (Exception e) {
			System.out.println("转换异常");
			e.printStackTrace();
			return lists;
		}
	}
}
