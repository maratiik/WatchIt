package com.maratik.watchit.data_classes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {

    private boolean adult;

    @JsonAlias("backdrop_path")
    private String backdropPath;

    private int id;

    @JsonAlias("name")
    private String title;

    @JsonAlias("original_language")
    private String originalLanguage;

    @JsonAlias({"original_name", "original_title"})
    private String originalTitle;

    private String overview;

    @JsonAlias("poster_path")
    private String posterPath;

    @JsonAlias("media_type")
    private String mediaType;

    @JsonAlias("genre_ids")
    private Set<Integer> genreIds;

    private double popularity;

    @JsonAlias({"first_air_date", "release_date"})
    private String releaseDate;

    private boolean video;

    @JsonAlias("vote_average")
    private double voteAverage;

    @JsonAlias("vote_count")
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
                Objects.equals(originalTitle, that.originalTitle) &&
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
                title, originalLanguage, originalTitle,
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
                ", OriginalTitle='" + originalTitle + '\'' +
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
