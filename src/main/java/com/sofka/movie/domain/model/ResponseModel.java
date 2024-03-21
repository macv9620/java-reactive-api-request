package com.sofka.movie.domain.model;

import java.util.List;

public class ResponseModel {
    private String page;
    private Integer totalPages;
    private Integer totalResults;

    private List<MovieModel> movies;

    public ResponseModel(String page, Integer totalPages, Integer totalResults, List<MovieModel> movies) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.movies = movies;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
