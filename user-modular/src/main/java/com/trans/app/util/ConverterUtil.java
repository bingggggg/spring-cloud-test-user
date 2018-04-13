package com.trans.app.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {
	/**
	 * 实体与dto相互转换
	 * 
	 * @param t
	 *            目标类
	 * @param d
	 *            被转换类
	 * @param o
	 *            转换对象
	 * @return 目标对象
	 */
	public static <T, D> T convert(T t, D d, Object o) {

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
						fields[i].set(obj, field[j].get(o));
					}
				}
			}
			return (T) obj;
		} catch (Exception e) {
			System.out.println("转换异常");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 集合对象转换
	 * 
	 * @param t
	 *            目标集合对象类型
	 * @param d
	 *            被转换集合对象类型
	 * @param list
	 *            被转换对象
	 * @return
	 */
	public static <T, D> List<T> convertList(T t, D d, List<D> list) {

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
							field[j].setAccessible(true);
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
