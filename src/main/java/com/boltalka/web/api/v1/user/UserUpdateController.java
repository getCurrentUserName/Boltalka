package com.boltalka.web.api.v1.user;

import com.boltalka.domain.dto.ResponseResult;
import com.boltalka.components.enums.Roles;
import com.boltalka.domain.entities.user.User;
import com.boltalka.services.user.UserDetailsServiceImpl;
import com.boltalka.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/update")
@PropertySource(value = { "classpath:app.properties" })
@Secured({Roles.ROLE_ADMIN, Roles.ROLE_USER})
public class UserUpdateController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    Environment env;

    /**
     * Обновить пароль
     * @param password - новый пароль
     * */
    @RequestMapping(value = "password", method = RequestMethod.POST)
    public ResponseResult updatePassword(@RequestParam(value = "password") String password) {
        User current_user = userDetailsService.getCurrentUser();
        current_user.setPassword(passwordEncoder.encode(password));
        return new ResponseResult(userService.update(current_user));
    }

    /**
     * Обновить логин
     * @param username - новый логи
     * */
    @RequestMapping(value = "username", method = RequestMethod.POST)
    public ResponseResult updateUsername(@RequestParam(value = "username") String username) {
        User current_user = userDetailsService.getCurrentUser();
        current_user.setUsername(username);
        return new ResponseResult(userService.update(current_user));
    }

    /**
     * Обновить ник
     * @param nickname - новый ник
     * */
    @RequestMapping(value = "nickname", method = RequestMethod.POST)
    public ResponseResult updateNickname(@RequestParam(value = "nickname") String nickname) {
        User current_user = userDetailsService.getCurrentUser();
        current_user.setNickname(nickname);
        return new ResponseResult(userService.update(current_user));
    }
}
