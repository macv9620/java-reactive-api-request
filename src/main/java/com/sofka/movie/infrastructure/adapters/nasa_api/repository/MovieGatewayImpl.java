package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.ResponseModel;
import com.sofka.movie.domain.model.gateways.IMovieGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MovieGatewayImpl implements IMovieGateway {
    private final MovieApiRepository movieApiRepository;

    public MovieGatewayImpl(MovieApiRepository movieApiRepository) {
        this.movieApiRepository = movieApiRepository;
    }

    @Override
    public Mono<ResponseModel> getMoviesByName(String movieName) {

        return movieApiRepository.getMovies(movieName);
    }
}
