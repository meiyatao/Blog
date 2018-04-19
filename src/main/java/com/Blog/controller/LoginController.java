package com.Blog.controller;

import com.Blog.aspect.SystemControllerLog;
import com.Blog.utils.DateUtil;
import com.Blog.utils.MD5Util;
import com.Blog.utils.PropertiesFactoryHelper;
import com.Blog.utils.TCPIPUtil;

import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xukaiwei 2015-8-3
 */
@Controller
public class LoginController extends BaseController {
	@SystemControllerLog(description = "初试")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
		
        log.info("进入主页！");
        request.getSession().setAttribute("message", "");
        return "home";
    }


}
