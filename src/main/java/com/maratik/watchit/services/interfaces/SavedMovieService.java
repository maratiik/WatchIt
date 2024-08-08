package com.maratik.watchit.services.interfaces;

import com.maratik.watchit.entities.SavedMovie;

import java.util.List;
import java.util.Optional;

public interface SavedMovieService {

    Optional<SavedMovie> findByIdAndUserUsername(long id, String username);

    List<SavedMovie> findAllByUserUsername(String username);

    List<SavedMovie> findAllContainingTitleAndByUserUsername(String title, String username);

    List<SavedMovie> findAllByMediaTypeAndUserUsername(String mediaType, String username);

    SavedMovie save(SavedMovie savedMovie);

    SavedMovie update(SavedMovie savedMovie);

    void deleteByIdAndUserUsername(long id, String username);
}
