package com.boltalka.web.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LucidMinds on 07.05.16.
 * package com.boltalka.web.views;
 */
@Controller
public class Index {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("room")
    public String room() {
        return "room/room";
    }

    @RequestMapping("help")
    public String help() {
        return "help";
    }

}

