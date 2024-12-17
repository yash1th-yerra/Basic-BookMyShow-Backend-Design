package com.bms.BasicBookMyShow.sorter;

import com.bms.BasicBookMyShow.model.Show;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CheapShowSort implements SortingStrategy {

    @Override
    public List<Show> sort(List<Show> shows) {
        return shows.stream()
                .sorted(Comparator.comparingDouble(Show::getPrice))
                .collect(Collectors.toList());
    }
}
