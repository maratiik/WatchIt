package com.maratik.watchit.controllers;

import com.maratik.watchit.constants.Urls;
import com.maratik.watchit.data_classes.SearchPage;
import com.maratik.watchit.services.interfaces.TMDBSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Urls.API_SEARCH)
public class TMDBSearchController {

    private final TMDBSearch search;

    public TMDBSearchController(TMDBSearch search) {
        this.search = search;
    }

    @GetMapping
    public SearchPage search(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "mediaType") String mediaType,
            @RequestParam(value = "page") Integer page) {
        System.out.printf("SearchController.search(%s, %s, %d)%n", query, mediaType, page);
        SearchPage res = search.search(query, mediaType, page);
        System.out.println(res);
        return res;
    }
}
