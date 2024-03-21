package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.ResponseModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
@Repository
public class MovieApiRepository {
//    @Value("${movie.api.jwt}")
//    @Value("${movie.api.base.url}")
//    @Value("${movie.api.get.movies.endpoint}")

    private final String jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMjdmNGNhNjU4MTJhMzk5YTg5ODczZDYwN2QwNGZjYiIsInN1YiI6IjYzZTMwZTM1NTY4NDYzMDBjMjVkMmMwNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.THrEmZcp_8uBHLCtHz-_mB5A6M1yDCZ6oQu0dqJq6PU";
    private final String baseUrl = "https://api.themoviedb.org";
    private String getMoviesEndpoint = "/3/search/movie?include_adult=false&language=en-US&page=1&query=";

    private final WebClient webClient = WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader("Authorization", "Bearer " + jwtToken)
            .build();;
    public MovieApiRepository() {

    }
    public Mono<ResponseModel> getMovies(String movieName) throws RuntimeException {
        return webClient.get()
                .uri(getMoviesEndpoint + movieName)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode().value() == 401) {
                        return Mono.error(new RuntimeException("Unauthorized"));
                    }
                    return Mono.error(ex);
                });
    }
}