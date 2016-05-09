package com.boltalka.services;

import com.boltalka.dao.NewsDAO;
import com.boltalka.domain.entities.news.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService extends BaseService {

    @Autowired
    NewsDAO newsDAO;

    private static final int max = 10;

    public long getCount() {
        long count = newsDAO.getCount();
        return count / max;
    }

    public List<News> getNews() {
        return newsDAO.getNews(number, max);
    }

    public List<News> getNews(int number) {
        return newsDAO.getNews(number * max, max);
    }
}
