package com.wangzhen.spbjsonbase.miao.controller;

/**
 * @ClassName AppController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/24 下午6:45
 **/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getjson")
    public String getjson() {
        return "getjson";
    }

}
