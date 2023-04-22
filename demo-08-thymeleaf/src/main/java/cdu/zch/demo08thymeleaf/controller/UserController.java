package cdu.zch.demo08thymeleaf.controller;

import cdu.zch.demo08thymeleaf.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zch
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ModelAndView login(String username, String password, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        User user = new User(username, password);
        mv.addObject(user);
        mv.setViewName("redirect:/");
        System.out.println("登录的用户名密码为：" + user);

        request.getSession().setAttribute("user", user);

        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/page/login");
    }
}
