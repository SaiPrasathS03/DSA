package TaxiBooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
	private int id;
	private String currentLoc = "A";
	private int earnings=0;
	
	private List<Booking> bookings = new ArrayList<>();
	public Taxi(int id) {
		this.id = id;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentLoc() {
		return currentLoc;
	}
	public void setCurrentLoc(String currentLoc) {
		this.currentLoc = currentLoc;
	}
	public int getEarnings() {
		return earnings;
	}
	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}
	
	public boolean isAvailable(int time) {
		
		if(bookings.size()==0 || (bookings.size()!=0 && time>=(bookings.get(bookings.size()-1)).getDropTime())) {
			return true;
		}
		return false;
	}
	
	public static void addEarnings(Taxi taxi,int amount) {
		taxi.setEarnings(taxi.getEarnings()+amount);
	}
	
	public void displayDetails(Taxi taxi) {
		for(Booking b:bookings) {
			System.out.println(b+", earnings="+taxi.getEarnings());
		}
	}
}
