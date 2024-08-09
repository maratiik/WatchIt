package com.maratik.watchit.controllers;

import com.maratik.watchit.constants.Urls;
import com.maratik.watchit.entities.SavedMovie;
import com.maratik.watchit.repositories.UserRepository;
import com.maratik.watchit.services.interfaces.SavedMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Urls.API_MOVIES)
public class SavedMovieController {

    private final SavedMovieService movieService;

    private final UserRepository userRepository;

    public SavedMovieController(
            SavedMovieService movieService,
            UserRepository userRepository) {
        this.movieService = movieService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<SavedMovie> findMovies(@RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "media_type", required = false) String mediaType,
                                       Principal principal) {
        if (title == null) {
            if (mediaType == null) {
                return movieService.findAllByUserUsername(principal.getName());
            } else {
                return movieService.findAllByMediaTypeAndUserUsername(mediaType, principal.getName());
            }
        } else {
            return movieService.findAllContainingTitleAndByUserUsername(title, principal.getName());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SavedMovie> findById(Principal principal, @PathVariable Long id) {
        Optional<SavedMovie> movie = movieService.findByIdAndUserUsername(id, principal.getName());
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
