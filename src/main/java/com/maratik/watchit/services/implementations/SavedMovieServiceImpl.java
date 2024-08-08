package com.maratik.watchit.services.implementations;

import com.maratik.watchit.entities.SavedMovie;
import com.maratik.watchit.repositories.SavedMovieRepository;
import com.maratik.watchit.services.interfaces.SavedMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedMovieServiceImpl implements SavedMovieService {

    private final SavedMovieRepository repository;

    public SavedMovieServiceImpl(SavedMovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SavedMovie> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<SavedMovie> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SavedMovie> findAllContainingTitle(String title) {
        return repository.findAllContainingTitle(title);
    }

    @Override
    public List<SavedMovie> findAllByMediaType(String mediaType) {
        return repository.findAllByMediaType(mediaType);
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
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
