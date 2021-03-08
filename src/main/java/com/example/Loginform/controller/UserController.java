package com.example.Loginform.controller;

import com.example.Loginform.domain.User;
import com.example.Loginform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public ModelAndView login()
    {
        ModelAndView mav=new ModelAndView("login");
        mav.addObject("user",new User());
        return mav;
    }
    @PostMapping("/login")
    public String login(@org.jetbrains.annotations.NotNull @ModelAttribute("user") User user){
        User oauthUser=userService.login(user.getUsername(),user.getPassword());
        System.out.println(oauthUser);
        if(Objects.nonNull(oauthUser)){
            return "redirect:/success";
        }
        else
        {
            return "redirect:/error";
        }
    }
}
