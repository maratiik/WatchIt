package com.maratik.watchit.controllers;

import com.maratik.watchit.constants.Urls;
import com.maratik.watchit.services.interfaces.SavedMovieService;
import com.maratik.watchit.services.interfaces.TMDBSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: implement Spring Security and add User info everywhere
@RestController
@RequestMapping(Urls.MOVIES)
public class SavedMovieController {

    private final SavedMovieService service;

    private final TMDBSearch tmdbSearch;

    public SavedMovieController(SavedMovieService service, TMDBSearch tmdbSearch) {
        this.service = service;
        this.tmdbSearch = tmdbSearch;
    }
}
