package FlightTicketBooking;

import java.util.List;
import java.util.Scanner;

public class FlightTicketBookingSystem {
	static Flight flight1 = null;
	static Flight flight2 = null;
	static Scanner sc = new Scanner(System.in);
	public FlightTicketBookingSystem() {
		 flight1 = new Flight("Indigo");
		 flight2 = new Flight("Air India");
	}
	
	
	static void bookTicket() {
		Flight flightChosen = getFlightName();
		String name=getName();
		int age  = getAge();		
		int numSeats = getSeats();
		if(numSeats>flightChosen.getAvailableSeats()) {
			System.out.println("Number of seats available is: "+flightChosen.getAvailableSeats());
			System.out.println("-----Please try other flights-----");
			return;
		}
		Passenger p = new Passenger(name, age, numSeats, flightChosen.getFlightName());
		if(flightChosen.available()) {
			System.out.println("Tickets Booked Successfully and your id is "+p.getId());
			flightChosen.setAvailableSeats(flightChosen.getAvailableSeats()-numSeats);
			flightChosen.setTicketPrice(flightChosen.getTicketPrice()+(numSeats*200));
			flightChosen.getPassengerList().add(p);
		}
		
	}
	private static Flight getFlightName() {
		String flightName = null;
		Flight flightChosen;
		do {
			try {
			System.out.print("Enter Flight Name (Indigo/Air India): ");
			flightName = sc.nextLine();
			
			if(flightName.equalsIgnoreCase("Indigo")) {
				flightChosen = flight1;
				System.out.println(flight1);
				break;
			}
			else if(flightName.equalsIgnoreCase("Air India")){
				flightChosen = flight2;
				System.out.println(flight2);
				break;
			}
			else System.out.println("-----Enter valid flight name-----");
			}catch (Exception e) {
				System.out.println("-----Enter valid flightName-----");
			}
		}while(true);
		return flightChosen;
	}


	private static int getSeats() {
		int seats=0;
		try {
			do {
				System.out.print("Enter number seats to be booked");
				seats = Integer.parseInt(sc.nextLine());
				if(seats<=0 || seats>50) System.out.println("-----Enter the seats(1-50)");
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid seatnumber-----");
		}
		return seats;
	}
	private static int getAge() {
		int age=0;
		try {
			do {
				System.out.print("Enter your age: ");
				age = Integer.parseInt(sc.nextLine());
				if(age<=0 || age>120) System.out.println("-----Enter the age(1-120)-----");
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid age-----");
		}
		return age;
	}
	private static String getName() {
		String name="";
		try {
			do {
				System.out.print("Enter your name: ");
				name = sc.nextLine();
				if(name.length()<=2 || name.length()>50) System.out.println("-----Enter valid name-----");
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid name-----");
		}
		return name;
	}
	
	static void cancelTicket() {
		Flight flightChosen = getFlightName();
		System.out.println("Enter your id to cancel tickets");
		String id =sc.nextLine();
		List<Passenger> pList = flightChosen.getPassengerList();
		int isValid=0;
		Passenger passenger = null;
		for(Passenger p:pList) {
			if(id.equals(p.getId())) {
				isValid=1;
				passenger=p;
				break;
			}
		}
		if(isValid==0) {
			System.out.println("-----Enter valid id-----");
			cancelTicket();
			return;
		}
		System.out.println("Enter how many tickets to be cancelled:");
		int seats = Integer.parseInt(sc.nextLine());
		if(seats<=passenger.getSeatsBooked()) {
			flightChosen.setAvailableSeats(flightChosen.getAvailableSeats()+seats);
			flightChosen.setTicketPrice(flightChosen.getTicketPrice()-(200*seats));
			pList.remove(passenger);
		}
		
		
		
	}


	public void displayFlight() {
		getFlightName();
	}
}
