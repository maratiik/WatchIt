package com.maratik.watchit.entities;

import com.maratik.watchit.data_classes.SearchResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "saved_movie")
public class SavedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long savedMovieId;

    @Column
    private boolean finished = false;

    @Column
    private byte rating = 0;

    @Embedded
    private SearchResult searchResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedMovie that = (SavedMovie) o;
        return savedMovieId == that.savedMovieId && Objects.equals(searchResult, that.searchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savedMovieId, searchResult);
    }

    @Override
    public String toString() {
        return "SavedMovie{" +
                "savedMovieId=" + savedMovieId +
                ", searchResult=" + searchResult +
                '}';
    }
}
