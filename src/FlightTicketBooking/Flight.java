package FlightTicketBooking;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int flightId;
	private String flightName;
	private int availableSeats;
	private int ticketPrice;
	private static int id=1;
	private List<Passenger> passengerList = new ArrayList<>();
	public Flight(String flightName) {
		super();
		this.flightId = id++;
		this.flightName = flightName;
		this.availableSeats = 50;
		this.ticketPrice = 5000;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int avilableSeats) {
		this.availableSeats = avilableSeats;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", availableSeats=" + availableSeats
				+ ", ticketPrice=" + ticketPrice + "]";
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public static void displayFlightDetails(Flight flight) {
		
	}
	public boolean available() {
		if(availableSeats>0) return true;
		return false;
	}
	
	
}
