package com.boltalka.domain.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "user_table", indexes = {
        @Index(name = User.NICKNAME + "_index",  columnList = User.NICKNAME)
})
@DynamicUpdate
@DynamicInsert
public class User {

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NICKNAME = "nickname";
    public static final String ROLE = "role";

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = ID)
    @Type(type="pg-uuid")
    private UUID id;

    /** Логин */
    @Column(name = USERNAME, unique = true, nullable = false, length = 32)
    private String username;

    /** Пароль */
    @JsonIgnore
    @Column(name = PASSWORD, nullable = false)
    private String password;

    /** Ник */
    @Column(name = NICKNAME)
    private String nickname;

    /** Роль */
    @JsonIgnore
    @Column(name = ROLE, nullable = false, length = 24)
    private String role;

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
