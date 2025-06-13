package RailwayTicketBooking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketBooking {
	static final int BERTH_LIMIT = 1;
	static final int RAC = 1;
	static final int WAIT = 1;
	private static int upperSeatNum = 1;
	private static int middleSeatNum = 2;
	private static int lowerSeatNum = 3;

	static List<Passenger> confirmedList = new ArrayList<>();
//	static List<Passenger> RACList = new ArrayList<>();
//	static List<Passenger> waitingList = new ArrayList<>();
	static List<Passenger> upperList = new ArrayList<>();
	static List<Passenger> lowerList = new ArrayList<>();
	static List<Passenger> middleList = new ArrayList<>();

	static Queue<Passenger> racQueue = new LinkedList<>();
	static Queue<Passenger> waitingQueue = new LinkedList<>();

	public void bookTicket(Passenger p) {
		
		if (upperList.size() == BERTH_LIMIT && lowerList.size() == BERTH_LIMIT && middleList.size() == BERTH_LIMIT) {
			if(updateRACQueue(p)) {
				System.out.println("Ticket in RAC");
			}
			else if(updateWaitQueue(p)) {
				System.out.println("Ticket in waiting list");
			}
			else System.out.println("Sorry,No Tickets Avilable!!!");
		} else if (checkAvailability(p)) {
			p.setTicketType("Confirmed");
			confirmedList.add(p);
			System.out.println("Ticket Booked - Confirmed");
		}
	}

	private boolean updateWaitQueue(Passenger p) {
		if(waitingQueue.size()<WAIT) {
			p.setTicketType("Waiting List");
			waitingQueue.offer(p);
			return true;
		}
		return false;
	}

	private boolean updateRACQueue(Passenger p) {
		if(racQueue.size()<RAC) {
			p.setTicketType("RAC");
			racQueue.offer(p);
			return true;
		}
		return false;
	}

	private boolean checkAvailability(Passenger p) {
		if (p.getPreference().equalsIgnoreCase("U")) {
			if (upperList.size() < BERTH_LIMIT) {
				p.setPreference("U");
				p.setSeatNumber(upperSeatNum);
				upperSeatNum += 3;
				upperList.add(p);
				return true;
			}
			else {
				notAvailablePref(p);
			}
			

		} else if (p.getPreference().equalsIgnoreCase("M")) {
			if(middleList.size() < BERTH_LIMIT) {
				p.setPreference("M");
				p.setSeatNumber(middleSeatNum);
				middleSeatNum += 3;
				middleList.add(p);
				return true;
			}
			else {
				notAvailablePref(p);
			}
		} 
		else if(p.getPreference().equalsIgnoreCase("L")) {
			if(lowerList.size() < BERTH_LIMIT) {
				p.setPreference("L");
				p.setSeatNumber(lowerSeatNum);
				lowerSeatNum += 3;
				lowerList.add(p);
				return true;
			}
			else {
				notAvailablePref(p);
			}
		} 
		return false;
	}

	private void notAvailablePref(Passenger p) {
		System.out.println("Your preferred berth is not available.");
		View.displayAvailableList();
		getPreferenceAgain(p);
	}

	private void getPreferenceAgain(Passenger p) {
		String pref = RailwayTicketBookingSystem.getPreference();
		p.setPreference(pref);
		bookTicket(p);
	}

}
