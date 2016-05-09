package com.boltalka.dao;

import com.boltalka.domain.entities.news.News;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NewsDAO extends BaseDAO {

    public long getCount() {
        Criteria criteria = getSession().createCriteria(News.class);
        criteria.setCacheable(true);
        return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).longValue();
    }

    @SuppressWarnings("unchecked")
    public List<News> getNews(int number, int max) {
        Criteria criteria = getSession().createCriteria(News.class);
        criteria.addOrder(Order.desc(News.DATE));
        criteria.setFirstResult(number);
        criteria.setMaxResults(max);
        criteria.setCacheable(true);
        return criteria.list();
    }

}
