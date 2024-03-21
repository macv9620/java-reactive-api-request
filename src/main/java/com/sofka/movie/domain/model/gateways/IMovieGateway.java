package com.sofka.movie.domain.model.gateways;

import com.sofka.movie.domain.model.MovieModel;
import reactor.core.publisher.Flux;

public interface IMovieGateway {
    Flux<MovieModel> getMoviesByName(String movieName);
}
