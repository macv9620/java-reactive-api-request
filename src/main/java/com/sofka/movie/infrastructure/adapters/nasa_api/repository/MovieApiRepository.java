package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.MovieModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class MovieApiRepository {
    private final WebClient webClient = WebClient.create("https://api.themoviedb.org");

    public Flux<MovieModel> getMovies(String movieName){
        return webClient.get()
                .uri("/3/search/movie?include_adult=false&language=en-US&page=1&api_key=c27f4ca65812a399a89873d607d04fcb&query=" + movieName)
                .retrieve()
                .bodyToFlux(MovieModel.class);
    }
}