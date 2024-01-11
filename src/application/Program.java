package application;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import motel.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), dtf1);
		
		System.out.print("Check-out date (dd/MM/yy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), dtf1);

		
		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date:");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = LocalDate.parse(sc.next(), dtf1);
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = LocalDate.parse(sc.next(), dtf1);
		
		String error = reservation.updateDates(checkIn, checkOut);
		
		if (error != null) {
			System.out.println("Error in reservation: " + error);
		}
		else {
			System.out.println("Reservation: " + reservation);
		}
		
		sc.close();
	}

}
	
}
