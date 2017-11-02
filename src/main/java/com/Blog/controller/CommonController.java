package com.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zwt on 2017/10/27
 **/
@Controller
public class CommonController {

    @RequestMapping(value = "/riskQuery")
    public String riskQuery(){
        return "riskQuery/index";
    }
    @RequestMapping(value = "/riskMonitor")
    public String riskMonitor(){
        return "riskMonitor/index";
    }
    @RequestMapping(value = "/riskReport")
    public String riskReport(){
        return "riskReport/index";
    }
    @RequestMapping(value = "/userCenter")
    public String userCenter(){
        return "userCenter/index";
    }
}
