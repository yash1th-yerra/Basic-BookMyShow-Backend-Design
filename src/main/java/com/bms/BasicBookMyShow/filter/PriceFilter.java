package com.bms.BasicBookMyShow.filter;

import com.bms.BasicBookMyShow.model.Seat;
import com.bms.BasicBookMyShow.model.SeatStatus;
import com.bms.BasicBookMyShow.model.Show;

import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements Filter {
    private final double maxPrice;

    public PriceFilter(double maxPrice) {
        this.maxPrice = maxPrice;
    }
    @Override
    public List<Show> filter(List<Show> shows){
        return shows.stream()
                .filter(show -> show.getScreen().getSeats().values().stream()
                        .anyMatch(seat -> seat.getSeatStatus()== SeatStatus.AVAILABLE && Seat.getCategoryPrice(seat)<=maxPrice))
                .collect(Collectors.toList());
    }
}
