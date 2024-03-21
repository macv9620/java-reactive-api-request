package com.sofka.movie.app_service.config;

import com.sofka.movie.domain.model.gateways.IMovieGateway;
import com.sofka.movie.domain.usecase.movie.GetMoviesByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sofka.movie.infrastructure.adapters", "com.sofka.movie.infrastructure.entrypoints.movie"})
public class UseCasesConfig {
    @Bean
    public GetMoviesByNameUseCase createTransactionUseCase(IMovieGateway movieGateway){
        return new GetMoviesByNameUseCase(movieGateway);
    }
}
