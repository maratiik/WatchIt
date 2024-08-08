package com.maratik.watchit.controllers;

import com.maratik.watchit.constants.Urls;
import com.maratik.watchit.entities.SavedMovie;
import com.maratik.watchit.repositories.UserRepository;
import com.maratik.watchit.security.UserDetailsServiceImpl;
import com.maratik.watchit.services.interfaces.SavedMovieService;
import com.maratik.watchit.services.interfaces.TMDBSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Urls.MOVIES)
public class SavedMovieController {

    private final SavedMovieService movieService;

    private final UserRepository userService;

    private final TMDBSearch tmdbSearch;
    private final UserRepository userRepository;

    public SavedMovieController(
            SavedMovieService movieService,
            TMDBSearch tmdbSearch,
            UserDetailsServiceImpl userService, UserRepository userRepository) {
        this.movieService = movieService;
        this.tmdbSearch = tmdbSearch;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<SavedMovie> findAll(Principal principal) {
        return movieService.findAllByUserUsername(principal.getName());
    }

    @GetMapping("{id}")
    public ResponseEntity<SavedMovie> findById(Principal principal, @PathVariable Long id) {
        Optional<SavedMovie> movie = movieService.findByIdAndUserUsername(id, principal.getName());
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<SavedMovie> findAllContainingTitle(@RequestParam String title, Principal principal) {
        return movieService.findAllContainingTitleAndByUserUsername(title, principal.getName());
    }

    @GetMapping
    public List<SavedMovie> findAllByMediaType(@RequestParam String MediaType, Principal principal) {
        return movieService.findAllByMediaTypeAndUserUsername(MediaType, principal.getName());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SavedMovie savedMovie, Principal principal) {
        savedMovie.setUser(userRepository.findByUsername(principal.getName()).get());
        movieService.save(savedMovie);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody SavedMovie savedMovie, Principal principal) {
        savedMovie.setUser(userRepository.findByUsername(principal.getName()).get());
        movieService.update(savedMovie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Principal principal) {
        movieService.deleteByIdAndUserUsername(id, principal.getName());
        return ResponseEntity.ok().build();
    }
}
