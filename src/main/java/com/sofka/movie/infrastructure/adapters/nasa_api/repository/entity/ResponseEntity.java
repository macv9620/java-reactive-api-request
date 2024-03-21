package com.sofka.movie.infrastructure.adapters.nasa_api.repository.entity;

import java.util.List;

public class ResponseEntity {
    private String page;
    private Integer total_pages;
    private Integer total_results;

    private List<MovieEntity> results;

    public ResponseEntity(String page, Integer total_pages, Integer total_results, List<MovieEntity> results) {
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
