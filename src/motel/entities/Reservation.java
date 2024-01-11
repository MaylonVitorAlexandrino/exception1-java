package motel.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	private static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration diff = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return diff.toDays();
	}
	
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut.isAfter(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date:";
		}
		else {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		}
	}
	
	@Override
	public String toString() {
		return "Room: "
			+ roomNumber 
			+ ", check-in: "
			+ checkIn.format(dtf1)
			+ ", check-out: "
			+ checkOut.format(dtf1)
			+ ", "
			+ duration()
			+ " nights.";
			
	}
	
}
