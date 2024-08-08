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
            "https://api.themoviedb.org/3/search/multi?query=interstellar&include_adult=false&language=en-US&page=";

    private final String movieSearchUrl =
            "https://api.themoviedb.org/3/search/movie?include_adult=false&language=en-US&page=";

    private final String tvSearchUrl =
            "https://api.themoviedb.org/3/search/tv?query=interstellar&include_adult=false&language=en-US&page=";

    @Value("${API_KEY}")
    private String apiKey;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public SearchPage search(String query) {
        return search(query, 1);
    }

    @Override
    public SearchPage search(String query, String mediaType) {
        return search(query, mediaType, 1);
    }

    @Override
    public SearchPage search(String query, int page) {
        return restTemplate.exchange(
                multiSearchUrl + String.valueOf(page),
                HttpMethod.GET,
                getHttpEntity(),
                SearchPage.class
        ).getBody();
    }

    @Override
    public SearchPage search(String query, String mediaType, int page) {
        switch (mediaType) {
            case MediaType.MOVIE -> {
                return restTemplate.exchange(
                        movieSearchUrl + String.valueOf(page),
                        HttpMethod.GET,
                        getHttpEntity(),
                        SearchPage.class
                ).getBody();
            }
            case MediaType.TV -> {
                return restTemplate.exchange(
                        tvSearchUrl + String.valueOf(page),
                        HttpMethod.GET,
                        getHttpEntity(),
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
