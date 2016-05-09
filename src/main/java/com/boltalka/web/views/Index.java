package com.boltalka.web.views;

import com.boltalka.domain.entities.user.User;
import com.boltalka.services.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by LucidMinds on 07.05.16.
 * package com.boltalka.web.views;
 */
@Controller
public class Index {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @RequestMapping("/")
    public ModelAndView index(Principal principal, ModelAndView modelAndView) {
        if (principal == null) {
            return new ModelAndView("index");
        }
        modelAndView.setViewName("index");
        User user = userDetailsService.getCurrentUser();
        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }

    @RequestMapping("room")
    public String room() {
        return "room/room";
    }

    @RequestMapping("help")
    public String help() {
        return "help";
    }

}

