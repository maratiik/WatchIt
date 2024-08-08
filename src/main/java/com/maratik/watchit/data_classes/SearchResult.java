package com.maratik.watchit.data_classes;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SearchResult {

    private boolean adult;
    private String backdropPath;
    private int id;
    private String title;
    private String originalLanguage;
    private String OriginalTitle;
    private String overview;
    private String posterPath;
    private String mediaType;
    private Set<Integer> genreIds;
    private double popularity;
    private String releaseDate;
    private boolean video;
    private double voteAverage;
    private int voteCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return adult == that.adult &&
                id == that.id &&
                Double.compare(popularity, that.popularity) == 0 &&
                video == that.video &&
                Double.compare(voteAverage, that.voteAverage) == 0 &&
                voteCount == that.voteCount &&
                Objects.equals(backdropPath, that.backdropPath) &&
                Objects.equals(title, that.title) &&
                Objects.equals(originalLanguage, that.originalLanguage) &&
                Objects.equals(OriginalTitle, that.OriginalTitle) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(posterPath, that.posterPath) &&
                Objects.equals(mediaType, that.mediaType) &&
                Objects.equals(genreIds, that.genreIds) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                adult, backdropPath, id,
                title, originalLanguage, OriginalTitle,
                overview, posterPath, mediaType,
                genreIds, popularity, releaseDate,
                video, voteAverage, voteCount);
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", OriginalTitle='" + OriginalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", genreIds=" + genreIds +
                ", popularity=" + popularity +
                ", releaseDate='" + releaseDate + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
