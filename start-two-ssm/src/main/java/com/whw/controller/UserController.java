package com.whw.controller;

import com.whw.domain.User;
import com.whw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping
    public String login(String loginName, String password, HttpServletRequest request) {
        User user = service.findByNameAndPassword(loginName, password);
        if (user == null) {
            request.setAttribute("msg", "用户名或密码错误，请重新登录");
            return "login.jsp";
        }
        service.updateLastLoginTime(user.getUser_id());
        request.getSession().setAttribute("user", user);
        String url = (String) request.getSession().getAttribute("url");
        if (url != null){
            return url;
        }
        return "/category/showAllOneLevelCategory";
    }

    @PostMapping("/checkName")
    @ResponseBody
    public List<String> checkName() {
        return service.findAllUserLoginName();
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(User user,HttpServletRequest request) {
        int i = service.insertUser(user);
        if (i == 1) {
            request.getSession().setAttribute("user",user);
            return "success";
        }
        return "error";
    }
}
