package com.maratik.watchit.data_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SearchPage {

    private int page;

    private Set<SearchResult> results;

    private int totalPages;

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
