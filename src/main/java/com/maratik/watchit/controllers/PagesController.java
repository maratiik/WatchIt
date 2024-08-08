package com.maratik.watchit.controllers;

import com.maratik.watchit.constants.Urls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping(Urls.INDEX)
    public String index() {
        return "index";
    }

    @GetMapping(Urls.MOVIES)
    public String movies() {
        return "movies";
    }

    @GetMapping(Urls.SEARCH)
    public String search() {
        return "search";
    }
}
