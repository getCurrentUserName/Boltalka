package com.boltalka.services.user;

import com.boltalka.components.enums.Roles;
import com.boltalka.dao.UserDAO;
import com.boltalka.components.enums.CommandStatus;
import com.boltalka.domain.entities.user.User;
import com.boltalka.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends BaseService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Поиск по id
     * @param id - id пользователя
     * */
    public User findById(UUID id) {
        return userDAO.findById(id);
    }

    /**
     * Поиск по логину
     * @param username - логин пользователя
     * */
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public CommandStatus register(User registerUser) {
        User user = findByUsername(registerUser.getUsername());
        registerUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        if (user != null) {
            return CommandStatus.USERNAME_EXIST;
        }
        registerUser.setRole(Roles.ROLE_USER);
        return persist(registerUser);
    }
}