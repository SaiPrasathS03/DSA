package RailwayTicketBooking;

import java.util.Scanner;

public class RailwayTicketBookingSystem {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean loop = true;

		while (loop) {
			System.out.println(
					"1. Book Ticket\n2. Cancel Ticket\n3. View Confirmed Tickets\n4. View RAC List\n5. View WaitingList\n6. Exit");
			System.out.print("Enter your choice: ");
			int choice = 0;
			try {
			choice = Integer.parseInt(sc.nextLine());
			}catch (Exception e) {
				System.out.println("-----Enter valid choice-----");
			}
			Passenger p = null;
			switch (choice) {
			case 1:
				TicketBooking booking = new TicketBooking();
				String name = getName();
				int age = getAge();
				String preference = getPreference();
				p = new Passenger(name, age, preference);
				booking.bookTicket(p);
				break;
			case 2:
				int pId = getPid();
				if(!TicketCancelling.cancelTicket(pId)) {
					System.out.println("No TicketId as you entered");
				}
				break;
			case 3:
				View.displayConfirmedTickets();
				break;
			case 4:
				View.displayRAC();
				break;
			case 5:
				View.displayWaitingList();
				break;
			case 6:
				loop=false;
				break;
			default:
				System.out.println("Enter valid choice");
			}
			
				

		}
	}

	private static int getPid() {
		int id = 0;
		do {
			try {
				System.out.println("Enter the ticket id to be cancelled: ");
				id = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("-----Please enter valid age in number-----");
			}
		} while (true);
		return id;
	}

	private static String getName() {
		String name = "";

		do {
			try {
				System.out.println("Enter your name: ");
				name = sc.nextLine();
				if (name.length() < 3 || name.length() > 50) {
					System.out.println("-----Please enter valid name-----");
				} else
					break;
			} catch (Exception e) {
				System.out.println("-----Please enter valid name-----");
			}
		} while (true);
		return name;
	}

	static String getPreference() {
		String preference = "";

		do {
			try {
				System.out.println("Enter your Berth Preference: ");
				preference = sc.nextLine();
				if (preference.length() != 1 || (!preference.equalsIgnoreCase("U") && !preference.equalsIgnoreCase("L")
						&& !preference.equalsIgnoreCase("M"))) {
					System.out.println("-----Please enter valid preference (U,M,L)-----");
				} else
					break;
			} catch (Exception e) {
				System.out.println("-----Please enter valid prefernece in a single character(U,M,L)-----");
			}
		} while (true);
		return preference;
	}

	private static int getAge() {
		int age = 0;
		do {
			try {
				System.out.println("Enter your age: ");
				age = Integer.parseInt(sc.nextLine());
				if (age <= 0 || age > 120) {
					System.out.println("-----Please enter valid age(between 1 and 120)-----");
				} else
					break;
			} catch (Exception e) {
				System.out.println("-----Please enter valid age in number-----");
			}
		} while (true);
		return age;
	}
}
