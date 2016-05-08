package com.boltalka.web.views.auth;

import com.boltalka.components.enums.CommandStatus;
import com.boltalka.domain.entities.user.User;
import com.boltalka.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.web.views.auth;
 */
@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView auth(Principal principal) {
        if (principal == null) {
            return new ModelAndView("auth/login", "menuLogin", "active");
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(Principal principal,
                                 @RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "password2") String password2,
                                 @RequestParam(value = "nickname") String nickname) {
        if (principal != null) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/register");
        modelAndView.addObject("menuRegister", "active");
        if (!password.equals(password2)) {
            modelAndView.addObject("result", CommandStatus.PASSWORD_INVALID);
            return modelAndView;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        modelAndView.addObject("result", userService.register(user));
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(Principal principal) {
        if (principal == null) {
            return new ModelAndView("auth/register", "menuRegister", "active");
        }
        return new ModelAndView("redirect:/");
    }
}
