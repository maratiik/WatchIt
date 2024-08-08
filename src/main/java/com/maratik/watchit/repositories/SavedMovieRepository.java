package com.maratik.watchit.repositories;

import com.maratik.watchit.entities.SavedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

//TODO: in the future add User to queries
@Repository
public interface SavedMovieRepository extends JpaRepository<SavedMovie, Long> {

    @Query("select s from SavedMovie s where s.searchResult.mediaType = ?1")
    List<SavedMovie> findAllByMediaType(String mediaType);

    @Query("select s from SavedMovie s where upper(s.searchResult.title) like upper(concat('%', ?1, '%'))")
    List<SavedMovie> findAllContainingTitle(String title);

}