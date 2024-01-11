package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.exceptions.DomainException;
import motel.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), dtf1);
			
			System.out.print("Check-out date (dd/MM/yy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), dtf1);
	
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), dtf1);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), dtf1);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(DateTimeParseException e){
			System.out.println("Invalid date format.");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
	sc.close();	
	}
	
}
