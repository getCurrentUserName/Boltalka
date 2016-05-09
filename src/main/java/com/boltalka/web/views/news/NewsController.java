package com.boltalka.web.views.news;

import com.boltalka.components.enums.Roles;
import com.boltalka.domain.entities.news.News;
import com.boltalka.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.web.views.news;
 */
@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "news")
    public ModelAndView news() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("news/news");
        modelAndView.addObject("menuNews", "active");
        modelAndView.addObject("newsList", newsService.getNews());
        modelAndView.addObject("pages", newsService.getCount());
        return modelAndView;
    }

    @Secured({Roles.ROLE_ADMIN, Roles.ROLE_USER})
    @RequestMapping(value = "news/add", method = RequestMethod.GET)
    public String addFeedBack() {
        return "news/add";
    }

    @RequestMapping(value = "news/{number}", method = RequestMethod.GET)
    public ModelAndView news(@PathVariable(value = "number") int number) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("news/news");
        modelAndView.addObject("menuNews", "active");
        modelAndView.addObject("newsList", newsService.getNews(number - 1));
        modelAndView.addObject("pages", newsService.getCount());
        return modelAndView;
    }
}
