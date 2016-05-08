package com.boltalka.dao;

import com.boltalka.domain.entities.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public class UserDAO extends BaseDAO {

    public User findById(UUID id) {
        return findById(User.class, id);
    }

    public User findByUsername(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq(User.USERNAME, username));
        criteria.setCacheable(true);
        return (User) criteria.uniqueResult();
    }
}
