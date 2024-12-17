package com.bms.BasicBookMyShow.addlFilter;

import com.bms.BasicBookMyShow.filter.Filter;
import com.bms.BasicBookMyShow.model.Show;

import java.util.List;
import java.util.stream.Collectors;

public class LocationFilter implements Filter {

    private final String location;

    public LocationFilter(String location) {
        this.location = location;
    }
    @Override
    public List<Show> filter(List<Show> shows){
        return shows.stream()
                .filter(show -> show.getScreen().getMultiplex().getLocation().equals(location))
                .collect(Collectors.toList());
    }
}
