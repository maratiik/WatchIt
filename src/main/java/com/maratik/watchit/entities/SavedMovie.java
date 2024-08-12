package com.maratik.watchit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    private User user;

    @Column
    private int id;

    @Column
    private String title;

    @Column
    private String originalLanguage;

    @Column
    private String originalTitle;

    @Column(length = 5000)
    private String overview;

    @Column
    private String posterPath;

    @Column
    private String mediaType;

    @Column
    private double popularity;

    @Column
    private String releaseDate;

    @Column
    private double voteAverage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedMovie that = (SavedMovie) o;
        return savedMovieId == that.savedMovieId &&
                finished == that.finished &&
                rating == that.rating &&
                id == that.id &&
                Double.compare(popularity, that.popularity) == 0 &&
                Double.compare(voteAverage, that.voteAverage) == 0 &&
                Objects.equals(user, that.user) &&
                Objects.equals(title, that.title) &&
                Objects.equals(originalLanguage, that.originalLanguage) &&
                Objects.equals(originalTitle, that.originalTitle) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(posterPath, that.posterPath) &&
                Objects.equals(mediaType, that.mediaType) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                savedMovieId, finished, rating,
                user, id, title,
                originalLanguage, originalTitle, overview,
                posterPath, mediaType, popularity,
                releaseDate, voteAverage);
    }

    @Override
    public String toString() {
        return "SavedMovie{" +
                "savedMovieId=" + savedMovieId +
                ", finished=" + finished +
                ", rating=" + rating +
                ", user=" + user +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", popularity=" + popularity +
                ", releaseDate='" + releaseDate + '\'' +
                ", voteAverage=" + voteAverage +
                '}';
    }
}
