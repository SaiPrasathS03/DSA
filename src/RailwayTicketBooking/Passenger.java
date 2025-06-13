package RailwayTicketBooking;

public class Passenger {
	private int ticketId;
	private String name;
	private int age;
	private String ticketType;
	private String preference;
	private int seatNumber;
	private static int id=1;
	public Passenger(String name, int age, String preference) {
		this.ticketId = id++;
		this.name = name;
		this.age = age;
		this.ticketType = ticketType;
		this.preference = preference;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Passenger.id = id;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "Passenger [ticketId=" + ticketId + ", name=" + name + ", age=" + age + ", ticketType=" + ticketType
				+ ", preference=" + preference + ", seatNumber=" + seatNumber + "]";
	}
	
	
	
	
}
