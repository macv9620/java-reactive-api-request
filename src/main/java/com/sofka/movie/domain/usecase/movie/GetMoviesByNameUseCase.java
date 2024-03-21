package com.sofka.movie.domain.usecase.movie;

import com.sofka.movie.domain.model.MovieModel;
import com.sofka.movie.domain.model.gateways.IMovieGateway;
import reactor.core.publisher.Flux;

import java.util.function.Function;


public class GetMoviesByNameUseCase implements Function<String, Flux<MovieModel>> {

    private final IMovieGateway movieGateway;

    public GetMoviesByNameUseCase(IMovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    @Override
    public Flux<MovieModel> apply(String movieName) {
        return movieGateway.getMoviesByName(movieName);
    }
}
