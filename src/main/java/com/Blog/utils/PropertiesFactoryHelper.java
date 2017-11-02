package com.Blog.utils;

import java.io.*;
import java.util.Properties;

/**
 * 
 * 
 * @author zhangwentao
 *
 */
public class PropertiesFactoryHelper {
	/**
	 * 私有的属性防止外部引用
	 */
	private static Properties properties;
	private static Long lastModified = 0l;

	/**
	 * 私有的默认构造函数，防止使用构造函数进行实例化
	 */

	private static void init() {

		String path = PropertiesFactoryHelper.class.getClassLoader().getResource("configuration.properties").getPath();
		properties = new Properties();
		try {

			InputStream inputStream = new FileInputStream(path);
			InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取配置信息key - value
	 */
	public static String getPro(String key) {
		if (properties == null || isPropertiesModified()) {
			init();
		}
		String value = properties.get(key).toString();
		return value;
	}

	// 判断是否被修改过
	private static boolean isPropertiesModified() {
		boolean returnValue = false;
		File file = new File(
				PropertiesFactoryHelper.class.getClassLoader().getResource("configuration.properties").getPath());
		if (file.lastModified() > lastModified) {
			lastModified = file.lastModified();
			returnValue = true;
		}
		return returnValue;
	}
}