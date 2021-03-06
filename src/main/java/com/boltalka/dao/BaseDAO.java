package com.boltalka.dao;

import com.boltalka.components.enums.CommandStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public <T> T findById(Class<T> type, final UUID id) {
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> type) {
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(type).list();
    }


    public CommandStatus persist(Object object) {
        try {
            getSession().persist(object);
            return CommandStatus.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return CommandStatus.ERROR;
        }
    }

    public CommandStatus merge(Object object) {
        try {
            getSession().merge(object);
            return CommandStatus.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return CommandStatus.ERROR;
        }
    }

    public CommandStatus update(Object object) {
        try {
            getSession().update(object);
            return CommandStatus.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return CommandStatus.ERROR;
        }
    }
    public CommandStatus delete(Object object) {
        try {
            getSession().delete(object);
            return CommandStatus.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return CommandStatus.ERROR;
        }
    }

    public UUID save(Object object) {
        return (UUID) getSession().save(object);
    }

}