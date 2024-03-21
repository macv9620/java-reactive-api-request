package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.infrastructure.adapters.nasa_api.repository.entity.ResponseApiEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class MovieApiRepository {
    @Value("${movie.api.jwt}")
    private String jwtToken;
    @Value("${movie.api.base.url}")
    private String baseUrl;
    @Value("${movie.api.get.movies.endpoint}")
    private String getMoviesEndpoint;

    public MovieApiRepository() {
    }

    public WebClient configWebClient() {
        return   WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + jwtToken)
                .build();
    }
    public Mono<ResponseApiEntity> getMovies(String movieName) throws RuntimeException {
        return this.configWebClient()
                .get()
                .uri(getMoviesEndpoint + movieName)
                .retrieve()
                .bodyToMono(ResponseApiEntity.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode().value() == 401) {
                        return Mono.error(new RuntimeException("Unauthorized"));
                    }
                    return Mono.error(ex);
                });
    }
}