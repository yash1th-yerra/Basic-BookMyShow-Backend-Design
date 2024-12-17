package com.bms.BasicBookMyShow.filter;

import com.bms.BasicBookMyShow.model.Show;

import java.util.List;
import java.util.stream.Collectors;

public class LocationFilter implements Filter{

    private final String locationName;

    public LocationFilter(String locationName) {
        this.locationName = locationName;
    }
    @Override
    public List<Show> filter(List<Show> shows){
        return shows.stream()
                .filter(show -> show.getScreen().getMultiplex().getLocation().equals(locationName))
                .collect(Collectors.toList());
    }
}
