package com.sofka.movie.domain.model.gateways;

import com.sofka.movie.domain.model.MovieModel;
import com.sofka.movie.domain.model.ResponseModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieGateway {
    Mono<ResponseModel> getMoviesByName(String movieName);
}
