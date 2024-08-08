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
@RequestMapping(Urls.SEARCH)
public class TMDBSearchController {

    private final TMDBSearch search;

    public TMDBSearchController(TMDBSearch search) {
        this.search = search;
    }

    @GetMapping
    public ResponseEntity<SearchPage> search(@RequestParam("query") String query) {
        return ResponseEntity.ok(search.search(query));
    }

    @GetMapping
    public ResponseEntity<SearchPage> search(
            @RequestParam("query") String query,
            @RequestParam("mediaType") String mediaType) {
        return ResponseEntity.ok(search.search(query, mediaType));
    }

    @GetMapping
    public ResponseEntity<SearchPage> search(@RequestParam("query") String query,
                                             @RequestParam("page") int page) {
        return ResponseEntity.ok(search.search(query, page));
    }

    @GetMapping
    public ResponseEntity<SearchPage> search(@RequestParam("query") String query,
                                             @RequestParam("mediaType") String mediaType,
                                             @RequestParam("page") int page) {
        return ResponseEntity.ok(search.search(query, mediaType, page));
    }
}
