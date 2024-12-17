package com.bms.BasicBookMyShow.filter;

import com.bms.BasicBookMyShow.model.Show;

import java.util.List;

public class FilterManager {
    private Filter filterStrategy;

    public void setFilter(Filter filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public List<Show> applyFilter(List<Show> shows){
        if(filterStrategy == null){
            throw new IllegalStateException("No filter strategy is set");
        }
        return filterStrategy.filter(shows);
    }
}
