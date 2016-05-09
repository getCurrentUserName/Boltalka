package com.boltalka.web.api.v1.auth;

import com.boltalka.domain.dto.ResponseResult;
import com.boltalka.components.enums.CommandStatus;
import com.boltalka.components.enums.Roles;
import com.boltalka.domain.entities.user.User;
import com.boltalka.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/register")
@Secured({Roles.ROLE_ANONYMOUS})
public class RestRegister {

    @Autowired
    UserService userService;
    /**
     * Регистрация
     * @param username - логин
     * @param password - пароль
     * @param nickname - ник
     * */
    @RequestMapping(method = RequestMethod.POST)
    @Secured({Roles.ROLE_ANONYMOUS})
    public ResponseResult register(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "nickname") String nickname) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        CommandStatus commandStatus = userService.register(user);
        return new ResponseResult(commandStatus);
    }
}
