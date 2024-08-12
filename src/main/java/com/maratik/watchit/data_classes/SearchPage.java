package com.maratik.watchit.data_classes;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SearchPage {

    private int page;

    private List<SearchResult> results;

    @JsonAlias("total_pages")
    private int totalPages;

    @JsonAlias("total_results")
    private int totalResults;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchPage that = (SearchPage) o;
        return page == that.page &&
                totalPages == that.totalPages &&
                totalResults == that.totalResults &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, results, totalPages, totalResults);
    }

    @Override
    public String toString() {
        return "SearchPage{" +
                "page=" + page +
                ", results=" + results +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
