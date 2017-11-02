/**
 * 
 */
package com.Blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.Blog.utils.PropertiesFactoryHelper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xukaiwei 2015-12-02
 */
@Controller
public class BaseController {
	protected final Logger log = LoggerFactory.getLogger(BaseController.class);
	protected int pageSize = Integer.parseInt(PropertiesFactoryHelper.getPro("pageSize"));

	/**
	 * @Description: 获取request中参数
	 * @param  request
	 * @return Map<String,Object>  
	 * @author gucc
	 * @date 2016-2-29
	 */
	public Map<String, Object> formatParam(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        @SuppressWarnings("rawtypes")
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {  
            String paramName = (String) paramNames.nextElement();
  
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {  
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {  
                    try {
						map.put(paramName, URLDecoder.decode(paramValue,"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}  
                }  
            }  
        }
        return map;
    } 
	

}
