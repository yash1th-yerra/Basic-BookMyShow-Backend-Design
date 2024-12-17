package com.bms.BasicBookMyShow.filter;

import com.bms.BasicBookMyShow.model.Show;

import java.util.List;
import java.util.stream.Collectors;

public class GenreFilter implements Filter{
    private final String genre;

    public GenreFilter(String  genre) {
        this.genre = genre;
    }

    @Override
    public List<Show> filter(List<Show> shows){
        return shows.stream()
                .filter(show -> show.getMovie().getGenre().equals(genre))
                .collect(Collectors.toList());
    }
}
