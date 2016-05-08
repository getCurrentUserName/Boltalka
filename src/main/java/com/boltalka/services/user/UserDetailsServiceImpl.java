package com.boltalka.services.user;

import com.boltalka.domain.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                roles);
    }

    public User getCurrentUser() {
        try {
            return userService.findByUsername(getAuthUserName());
        } catch (Exception e) {
            return new User();
        }
    }

    public String getAuthUserName() {
        String currentUserName;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                currentUserName = ((UserDetails)principal).getUsername();
            } else {
                currentUserName = principal.toString();
            }
            return currentUserName;
        } catch (NullPointerException e) {
            currentUserName = e.toString();
            return currentUserName;
        }
        catch (Exception e) {
            currentUserName = e.toString();
            return currentUserName;
        }
    }

    /** Получить пароль пользователя */
    public String getAuthUserPassword() {
        String currentUserPassword;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                currentUserPassword = ((UserDetails)principal).getPassword();
            } else {
                currentUserPassword = principal.toString();
            }
            return currentUserPassword;
        } catch (NullPointerException e) {
            currentUserPassword = e.toString();
            return currentUserPassword;
        }
        catch (Exception e) {
            currentUserPassword = e.toString();
            return currentUserPassword;
        }
    }

    /** Получить роль пользователя */
    public Object getAuthUserRole() {
        Object currentUserRole;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication();
            if (principal instanceof UserDetails) {
                currentUserRole = ((UserDetails)principal).getAuthorities();
            } else {
                currentUserRole = principal;
            }
            return currentUserRole;
        } catch (NullPointerException e) {
            currentUserRole = e.toString();
            return currentUserRole;
        }
        catch (Exception e) {
            currentUserRole = e.toString();
            return currentUserRole;
        }
    }
}
