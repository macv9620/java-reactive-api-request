package com.sofka.movie.infrastructure.adapters.nasa_api.repository.mapper;

import com.sofka.movie.domain.model.MovieModel;
import com.sofka.movie.domain.model.ResponseModel;
import com.sofka.movie.infrastructure.adapters.nasa_api.repository.entity.MovieEntity;
import com.sofka.movie.infrastructure.adapters.nasa_api.repository.entity.ResponseApiEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperResponseApi {
    public ResponseModel toResponseApiModel(ResponseApiEntity responseApiEntity){
        return new ResponseModel(
              responseApiEntity.getPage(),
              responseApiEntity.getTotal_pages(),
              responseApiEntity.getTotal_results(),
              responseApiEntity.getResults().stream().map(this::toMovieModel).toList()

        );
    }
    public MovieModel toMovieModel(MovieEntity movieEntity){
        return new MovieModel(
                movieEntity.getId(),
                movieEntity.getOriginal_title(),
                movieEntity.getOverview(),
                movieEntity.getRelease_date(),
                movieEntity.getVote_average()
        );
    }


}
