package com.maratik.watchit.services.implementations;

import com.maratik.watchit.constants.MediaType;
import com.maratik.watchit.data_classes.SearchPage;
import com.maratik.watchit.services.interfaces.TMDBSearch;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@NoArgsConstructor
public class TMDBSearchImpl implements TMDBSearch {

    private final String multiSearchUrl =
            "https://api.themoviedb.org/3/search/multi?query=%s&include_adult=false&language=en-US&page=%s";

    private final String movieSearchUrl =
            "https://api.themoviedb.org/3/search/movie?query=%s&include_adult=false&language=en-US&page=%s";

    private final String tvSearchUrl =
            "https://api.themoviedb.org/3/search/tv?query=%s&include_adult=false&language=en-US&page=%s";

    @Value("${API_KEY}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public SearchPage search(String query, String mediaType, int page) {
        switch (mediaType) {
            case MediaType.MOVIE -> {
                return restTemplate.exchange(
                        movieSearchUrl.formatted(query, String.valueOf(page)),
                        HttpMethod.GET,
                        this.getHttpEntity(),
                        SearchPage.class
                ).getBody();
            }
            case MediaType.TV -> {
                return restTemplate.exchange(
                        tvSearchUrl.formatted(query, String.valueOf(page)),
                        HttpMethod.GET,
                        this.getHttpEntity(),
                        SearchPage.class
                ).getBody();
            }
            case MediaType.ANY -> {
                return restTemplate.exchange(
                        multiSearchUrl.formatted(query, String.valueOf(page)),
                        HttpMethod.GET,
                        this.getHttpEntity(),
                        SearchPage.class
                ).getBody();
            }
            default -> {
                return new SearchPage();
            }
        }
    }

    private HttpEntity<Object> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);
        return new HttpEntity<>(headers);
    }
}
