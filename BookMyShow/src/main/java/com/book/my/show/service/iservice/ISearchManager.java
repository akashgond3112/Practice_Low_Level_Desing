package com.book.my.show.service.iservice;


import com.book.my.show.model.Movie;

import java.util.List;

public interface ISearchManager {
    List<Movie> getMovieByName(String searchTerm);
}
