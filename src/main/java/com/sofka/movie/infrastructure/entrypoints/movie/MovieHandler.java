package com.sofka.movie.infrastructure.entrypoints.movie;

import com.sofka.movie.domain.usecase.movie.GetMoviesByNameUseCase;
import com.sofka.movie.infrastructure.entrypoints.movie.wrapper.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {
    private final GetMoviesByNameUseCase getMoviesByNameUseCase;

    public MovieHandler(GetMoviesByNameUseCase getMoviesByNameUseCase) {
        this.getMoviesByNameUseCase = getMoviesByNameUseCase;
    }

    public Mono<ServerResponse> getMoviesByName(ServerRequest request) {

        String name = request.queryParam("name").orElse(null);
        if (name == null) {
            return ServerResponse.badRequest().bodyValue(new ResponseWrapper<>("ID parameter is required", null));
        }

        System.out.println(name);

        return getMoviesByNameUseCase.apply(name)
                .flatMap(movieResult -> ServerResponse.ok().bodyValue(movieResult))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.UNAUTHORIZED)
                        .bodyValue(new ResponseWrapper<>(e.getMessage(), null)));
    }
}