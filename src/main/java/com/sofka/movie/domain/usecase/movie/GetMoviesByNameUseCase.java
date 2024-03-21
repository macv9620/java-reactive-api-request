package com.sofka.movie.domain.usecase.movie;

import com.sofka.movie.domain.model.ResponseModel;
import com.sofka.movie.domain.model.gateways.IMovieGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import reactor.core.publisher.Mono;

import java.util.function.Function;


public class GetMoviesByNameUseCase implements Function<String, Mono<ResponseModel>> {

    private final IMovieGateway movieGateway;

    public GetMoviesByNameUseCase(IMovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    @Override
    public Mono<ResponseModel> apply(String movieName) {
        return movieGateway.getMoviesByName(movieName);
    }
}
