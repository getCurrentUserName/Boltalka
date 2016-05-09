package com.boltalka.services;

import com.boltalka.components.enums.CommandStatus;
import com.boltalka.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BaseService {

    @Autowired
    private BaseDAO baseDAO;

    public static final int number = 0;

    /** Поиск по ID */
    public <T> T findById(Class<T> type, final UUID id) {
        return baseDAO.findById(type, id);
    }

    public <T> List<T> getAll(Class<T> type) {
        return baseDAO.getAll(type);
    }

    public CommandStatus persist(Object object) {
        return baseDAO.persist(object);
    }

    public UUID save(Object object) {
        return baseDAO.save(object);
    }

    public CommandStatus update(Object object) {
        return baseDAO.update(object);
    }

    public CommandStatus merge(Object object) {
        return baseDAO.merge(object);
    }

    public CommandStatus delete(Object object) {
        return baseDAO.delete(object);
    }
}
