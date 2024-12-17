package com.bms.BasicBookMyShow;

import com.bms.BasicBookMyShow.model.*;
import com.bms.BasicBookMyShow.service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BasicBookMyShowApplication {

	// This is hardcoded since this is designing process.

	public static void main(String[] args) {

		BookingService bookingService = BookingService.getInstance();

		Movie pushpa2 = new Movie("Pushpa-2","Telugu","Action","2024-12-05",3);
		Movie devara = new Movie("Devara","Telugu","Action","2024-08-05",3);
		Movie RRR = new Movie("RRR","Telugu","Action Drama","2023-08-13",3);

		Multiplex multiplex = new Multiplex("Lalitha","Peddapuram");

		Screen screen1 = new Screen("Screen1",multiplex,90);
		multiplex.addScreen(screen1);

		Show show1 = new Show(RRR,
				LocalDateTime.of(2024,12,18,19,00),
				LocalDateTime.of(2024,12,18,22,00),screen1);

		User user1 = new User("Yashwanth","abcd@gmail.com");


		Seat seat1 = new Seat(show1.getScreen().getSeats().get("1").getSeatNumber(),SeatCategory.GOLD);
		Seat seat2 = new Seat(show1.getScreen().getSeats().get("1").getSeatNumber(),SeatCategory.GOLD);

		Booking booking = bookingService.bookTicket(user1,show1, List.of(seat1,seat2));


		boolean isPaymentSuccess = true;
		if(booking!=null){
			System.out.println("Booking Successful BookingId: "+ booking.getId());
			if(isPaymentSuccess){
				bookingService.confirmBooking(booking.getId());
			}else{
				bookingService.cancelBooking(booking.getId());
			}
		}
	}
}
