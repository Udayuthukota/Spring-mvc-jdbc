package com.stackroute.controller;


import com.stackroute.configuration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    CrudOperation crudOperation;
    @Autowired
    User user;
    @RequestMapping("/")
    public String firstPage(){
        return "index";
    }



    @RequestMapping("/welcome")
    public String secondPage(ModelMap map,@RequestParam ("username") String name,@RequestParam ("password") String passw){
        user.setUsername(name);
        crudOperation.insertCustomer(name,passw);
        map.addAttribute("username",user.getUsername());
        return "welcome";
    }


}

