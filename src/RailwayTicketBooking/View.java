package RailwayTicketBooking;

public class View {

	public static void displayAvailableList() {
		System.out.println("Available Upper Berth: "+((TicketBooking.BERTH_LIMIT)-(TicketBooking.upperList.size())));
		System.out.println("Available Middle Berth: "+((TicketBooking.BERTH_LIMIT)-(TicketBooking.middleList.size())));
		System.out.println("Available Lower Berth: "+((TicketBooking.BERTH_LIMIT)-(TicketBooking.lowerList.size())));
	}
	
	public static void displayConfirmedTickets() {
		System.out.println("\n-----Confirmed Tickets-----");
		for(Passenger p:TicketBooking.confirmedList) {
			System.out.println(p);
		}
		System.out.println();
	}
	public static void displayRAC() {
		System.out.println("\n-----RAC Tickets-----");
		for(Passenger p:TicketBooking.racQueue) {
			System.out.println(p);
		}
		System.out.println();
	}
	public static void displayWaitingList() {
		System.out.println("\n-----Waiting List Tickets-----");
		for(Passenger p:TicketBooking.waitingQueue) {
			System.out.println(p);
		}
		System.out.println();
	}
	
	

}
