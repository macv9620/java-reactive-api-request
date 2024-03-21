package com.sofka.movie.infrastructure.entrypoints.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class MovieRouter {

    @Bean
    public RouterFunction<ServerResponse> movieRoutes(MovieHandler movieHandler) {
        return RouterFunctions.route(
                GET("/api/getByName")
                        .and(accept(MediaType.APPLICATION_JSON))
                        .and(queryParam("name", name -> true)),
                movieHandler::getMoviesByName);
    }
}
