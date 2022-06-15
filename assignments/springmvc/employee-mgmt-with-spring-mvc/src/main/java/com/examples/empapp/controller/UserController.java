package com.examples.empapp.controller;
import com.examples.empapp.dao.UserDao;
import com.examples.empapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(com.examples.empapp.controller.UserController.class);
    @Autowired
    public UserDao userdao;



    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView register(Model model) {
        return new ModelAndView("addUser", "command", new User());
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) {
        userdao.add(user);
        System.out.println("User Registered Successfully");
        return new ModelAndView("userRegistered","command", new User());
    }

}






