package com.bms.BasicBookMyShow.service;

import com.bms.BasicBookMyShow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private final List<Movie> movies;

    private final List<Multiplex> multiplexes;

    private final Map<String, Show> shows;

    private final Map<String, Booking> bookings;

    private static BookingService instance;

    private BookingService() {
        this.movies = new ArrayList<>();
        this.multiplexes = new ArrayList<>();
        this.shows = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public static synchronized BookingService getInstance(){
        if(instance ==null){
            instance = new BookingService();
        }
        return instance;
    }


    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void addMultiplex(Multiplex multiplex){
        this.multiplexes.add(multiplex);
    }

    public void addShow(Show show){
        this.shows.put(show.getId(), show);
    }

    public Map<String,Seat> availableSeats(Show show){
        Map<String,Seat> allSeats = show.getScreen().getSeats();
        Map<String,Seat> avlSeats = new HashMap<>();

        for(Map.Entry<String,Seat> entry : allSeats.entrySet()){
            Seat seat = entry.getValue();
            if(seat.getSeatStatus()==SeatStatus.AVAILABLE){
                avlSeats.put(entry.getKey(),seat);
            }
        }
        return avlSeats;

    }

    public Booking bookTicket(User user, Show show,List<Seat> selectedSeats){
        // check if seats are available
        if(areSeatsAvailable(selectedSeats,show)){
            // if yes change status of seat to  BOOKED and book that seat
            markSeatAsBooked(selectedSeats,show);
            // price

            double price = calculatePrice(selectedSeats,show);
            Booking booking = new Booking(user,show,selectedSeats,price);
            bookings.put(booking.getId(),booking);
            return booking;
        }
        return null;


    }

    public void confirmBooking(String bookingId){
        Booking booking = bookings.get(bookingId);
        if(booking.getBookingStatus()==BookingStatus.PENDING){
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        }
        System.out.println(" Booking Confirmed");
    }
    public void cancelBooking(String bookingId){
        Booking booking = bookings.get(bookingId);
        if(booking.getBookingStatus()==BookingStatus.CONFIRMED){
            booking.setBookingStatus(BookingStatus.CANCELLED);
            markSeatAsAvailable(booking.getReservedSeats(),booking.getShow());
        }
        System.out.println(" Booking Cancelled");
    }


    private void markSeatAsAvailable(List<Seat> selectedSeats,Show show){
        for(Seat seat : selectedSeats){
            Seat showSeat  = show.getScreen().getSeats().get(seat.getSeatNumber());
            showSeat.setSeatStatus(SeatStatus.AVAILABLE);
        }
    }

    private double calculatePrice(List<Seat> selectedSeats, Show show){
        return selectedSeats.stream().mapToDouble(Seat::getCategoryPrice).sum();
    }

    private void markSeatAsBooked(List<Seat> selectedSeats, Show show){
        for(Seat seat : selectedSeats){
            Seat showSeat  = show.getScreen().getSeats().get(seat.getSeatNumber());
            showSeat.setSeatStatus(SeatStatus.BOOKED);
        }
    }

    private boolean areSeatsAvailable(List<Seat> selectedSeats,Show show){
        for(Seat seat : selectedSeats){
            Seat showSeat  = show.getScreen().getSeats().get(seat.getSeatNumber());
            if(showSeat.getSeatStatus()!=SeatStatus.AVAILABLE){
                return false;
            }
        }
        return true;

    }
}
