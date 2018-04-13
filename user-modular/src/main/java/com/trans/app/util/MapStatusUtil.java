package com.trans.app.util;

import java.util.HashMap;
import java.util.Map;

public class MapStatusUtil {

	/**
	 * 
	 * @return status 200
	 */
	public static Map<String, String> getSuccess() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "success");
		return map;
	}

	/**
	 * 
	 * @param info
	 *            自定义信息
	 * @return status 200,info
	 */
	public static Map<String, String> getSuccess(String info) {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", info);
		return map;
	}

	/**
	 * 
	 * @return status 500
	 */
	public static Map<String, String> getError() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "500");
		map.put("info", "error");
		return map;
	}

	/**
	 * 
	 * @param info
	 *            自定义信息
	 * @return status 500,info
	 */
	public static Map<String, String> getError(String info) {
		Map<String, String> map = new HashMap<>();
		map.put("status", "500");
		map.put("info", info);
		return map;
	}
}
