package com.Blog.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具类
 */
public class MD5Util {

	public static void main(String[] args) {
		String s = "yanxuejuan123";
		System.out.println(md5(s));
//		System.out.println(String.valueOf(null));
	}

	/**
	 * md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		if (null == str || "".equals(str)) {
			return "";
		}
		return DigestUtils.md5Hex(str);
	}

}
