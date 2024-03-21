package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.MovieModel;
import com.sofka.movie.domain.model.ResponseModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MovieApiRepository {
    private final WebClient webClient = WebClient.create("https://api.themoviedb.org");

    public Mono<ResponseModel> getMovies(String movieName){
        return webClient.get()
                .uri("/3/search/movie?include_adult=false&language=en-US&page=1&api_key=c27f4ca65812a399a89873d607d04fcb&query=" + movieName)
                .retrieve()
                .bodyToMono(ResponseModel.class);
    }
}