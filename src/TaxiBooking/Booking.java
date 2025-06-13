package TaxiBooking;

public class Booking {
	private int bookingId;
	private int custId;
	private String origin;
	private String destination;
	private int pickupTime;
	private int dropTime;
	private int amount;
	private static int bId=1;
	private static int cId=1;
	
	public Booking(String origin, String destination, int pickupTime, int dropTime,int amount) {
		super();
		this.bookingId = bId++;
		this.custId = cId++;
		this.origin = origin;
		this.destination = destination;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.amount = amount;
	}
	
	public int getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public static int getbId() {
		return bId;
	}
	public static void setbId(int bId) {
		Booking.bId = bId;
	}
	public static int getcId() {
		return cId;
	}
	public static void setcId(int cId) {
		Booking.cId = cId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", custId=" + custId + ", origin=" + origin + ", destination="
				+ destination + ", pickupTime=" + pickupTime + ", dropTime=" + dropTime + ", amount=" + amount;
	}
	
}
