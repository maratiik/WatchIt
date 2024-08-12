package com.maratik.watchit.services.implementations;

import com.maratik.watchit.entities.SavedMovie;
import com.maratik.watchit.repositories.SavedMovieRepository;
import com.maratik.watchit.services.interfaces.SavedMovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SavedMovieServiceImpl implements SavedMovieService {

    private final SavedMovieRepository repository;

    public SavedMovieServiceImpl(SavedMovieRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SavedMovie> findByIdAndUserUsername(long id,
                                                        String username) {
        Optional<SavedMovie> movie = repository.findById(id);
        if (movie.isPresent()) {
            if (username.equals(movie.get().getUser().getUsername())) {
                return movie;
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavedMovie> findAllByUserUsername(String username) {
        return repository.findAllByUserUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavedMovie> findAllContainingTitleAndByUserUsername(String title,
                                                                    String username) {
        return repository.findAllContainingTitleAndByUserUsername(title, username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavedMovie> findAllByMediaTypeAndUserUsername(String mediaType,
                                                              String username) {
        return repository.findAllByMediaTypeAndUserUsername(mediaType, username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavedMovie> findAllContainingTitleAndByMediaTypeAndUserUsername(String title,
                                                                                String mediaType,
                                                                                String username) {
        return repository.findAllContainingTitleAndByMediaTypeAndUserUsername(title, mediaType, username);
    }

    @Override
    public SavedMovie save(SavedMovie savedMovie) {
        return repository.save(savedMovie);
    }

    @Override
    public SavedMovie update(SavedMovie savedMovie) {
        return repository.save(savedMovie);
    }

    @Override
    public void deleteByIdAndUserUsername(long id,
                                          String username) {
        Optional<SavedMovie> movie = repository.findById(id);

        if (movie.isPresent()) {
            if (username.equals(movie.get().getUser().getUsername())) {
                repository.deleteById(id);
            }
        }
    }
}
