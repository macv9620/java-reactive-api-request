package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.MovieModel;
import com.sofka.movie.domain.model.ResponseModel;
import com.sofka.movie.domain.model.gateways.IMovieGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieGatewayImpl implements IMovieGateway {
    private final MovieApiRepository movieApiRepository = new MovieApiRepository();
    @Override
    public Mono<ResponseModel> getMoviesByName(String movieName) {
        return movieApiRepository.getMovies(movieName);
    }
}
