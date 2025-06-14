package FlightTicketBooking;

import java.util.Scanner;

public class MainFlightTicketBooking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FlightTicketBookingSystem sys = new FlightTicketBookingSystem();
		while(true) {
			System.out.println("1. Book Ticket\n2. Cancel Ticket\n3. View Flight Details\n4. Exit");
			int choice=0;
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (Exception e) {
				System.out.println("-----Enter valid choice-----");
			}
			switch(choice) {
			case 1:
				sys.bookTicket();
				break;
			case 2:
				sys.cancelTicket();
				break;
			case 3:
				sys.displayFlight();
				break;
			case 4:
				return;
			}
			
		}
		

	}

}
