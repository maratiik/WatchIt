package com.maratik.watchit.repositories;

import com.maratik.watchit.entities.SavedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedMovieRepository extends JpaRepository<SavedMovie, Long> {

    @Query("select s from SavedMovie s where s.user.username = ?1")
    List<SavedMovie> findAllByUserUsername(String username);

    @Query("""
            select s from SavedMovie s
            where upper(s.searchResult.title) like upper(concat('%', ?1, '%')) and s.user.username = ?2""")
    List<SavedMovie> findAllContainingTitleAndByUserUsername(String title, String username);

    @Query("select s from SavedMovie s where s.searchResult.mediaType = ?1 and s.user.username = ?2")
    List<SavedMovie> findAllByMediaTypeAndUserUsername(String mediaType, String username);

}