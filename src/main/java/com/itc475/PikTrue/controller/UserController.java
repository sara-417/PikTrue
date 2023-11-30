package com.itc475.PikTrue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itc475.PikTrue.domain.User;
import com.itc475.PikTrue.mapper.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepo.findByUsernameAndPassword(username, password);
        
        if (user != null) {
            ModelAndView mav = new ModelAndView("image-display");
            mav.addObject("user", user);
            return mav;
        } else {
            return new ModelAndView("login", "error", "Invalid username or password");
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        return "redirect:/index";
    }
	
}
