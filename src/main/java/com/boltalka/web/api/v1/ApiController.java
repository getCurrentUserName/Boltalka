package com.boltalka.web.api.v1;

import com.boltalka.components.enums.Roles;
import com.boltalka.components.utils.EscapeUtil;
import com.boltalka.domain.dto.ResponseResult;
import com.boltalka.domain.entities.news.News;
import com.boltalka.services.BaseService;
import com.boltalka.services.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.web.api.v1;
 */
@RestController
@RequestMapping(value = "api/v1")
public class ApiController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    BaseService baseService;
    @Autowired
    EscapeUtil escapeUtil;

    @Secured({Roles.ROLE_ADMIN, Roles.ROLE_USER})
    @RequestMapping(value = "news/add", method = RequestMethod.POST)
    public ResponseResult addFeedBack(@RequestParam(value = "title") String title,
                                      @RequestParam(value = "text") String text) {
        News news = new News();
        news.setDate(new Date());
        news.setText(escapeUtil.escape(text));
        news.setTitle(escapeUtil.escape(title));
        news.setUserId(userDetailsService.getCurrentUser());
        return new ResponseResult(baseService.persist(news));
    }
}
