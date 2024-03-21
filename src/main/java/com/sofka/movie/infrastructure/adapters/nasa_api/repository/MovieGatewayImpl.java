package com.sofka.movie.infrastructure.adapters.nasa_api.repository;

import com.sofka.movie.domain.model.ResponseModel;
import com.sofka.movie.domain.model.gateways.IMovieGateway;
import com.sofka.movie.infrastructure.adapters.nasa_api.repository.mapper.MapperResponseApi;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MovieGatewayImpl implements IMovieGateway {
    private final MovieApiRepository movieApiRepository;
    private final MapperResponseApi mapperResponseApi;

    public MovieGatewayImpl(MovieApiRepository movieApiRepository, MapperResponseApi mapperResponseApi) {
        this.movieApiRepository = movieApiRepository;
        this.mapperResponseApi = mapperResponseApi;
    }

    @Override
    public Mono<ResponseModel> getMoviesByName(String movieName) {
        return movieApiRepository.getMovies(movieName).map(mapperResponseApi::toResponseApiModel);
    }
}
