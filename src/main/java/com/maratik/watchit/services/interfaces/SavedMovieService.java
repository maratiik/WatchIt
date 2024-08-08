package com.maratik.watchit.services.interfaces;

import com.maratik.watchit.entities.SavedMovie;

import java.util.List;
import java.util.Optional;

//TODO: in the future add User to queries
public interface SavedMovieService {

    Optional<SavedMovie> findById(long id);

    List<SavedMovie> findAll();

    List<SavedMovie> findAllContainingTitle(String title);

    List<SavedMovie> findAllByMediaType(String mediaType);

    SavedMovie save(SavedMovie savedMovie);

    SavedMovie update(SavedMovie savedMovie);

    void deleteById(long id);
}
