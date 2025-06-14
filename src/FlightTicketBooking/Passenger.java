package FlightTicketBooking;

import java.util.UUID;

public class Passenger {
	private String id;
	private String name;
	private int age;
	private int seatsBooked;
	private String flightName;
	public Passenger(String name, int age, int seatsBooked, String flightName) {
		super();
		this.id = UUID.randomUUID().toString().substring(0,8);
		this.name = name;
		this.age = age;
		this.seatsBooked = seatsBooked;
		this.flightName = flightName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	
}
