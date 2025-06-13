package RailwayTicketBooking;

import java.util.LinkedHashMap;
import java.util.Map;

public class TicketCancelling {
	private static int seatNum;
	private static String pref;
	static Map<Integer,String> cancelMap = new LinkedHashMap<>();
	public static boolean cancelTicket(int id) {
		int f=0;
		for(Passenger p:TicketBooking.confirmedList) {
			if(p.getTicketId()==id) {
				cancelMap.put(p.getSeatNumber(), p.getPreference());
				seatNum = p.getSeatNumber();
				pref = p.getPreference();
				racToConfirm();
				waitingToRac();
				TicketBooking.confirmedList.remove(p);
				f=1;
				break;
			}
		}
		if(f==0) {
			return false;
		}
		return true;
	}
	private static void waitingToRac() {
		if(!TicketBooking.waitingQueue.isEmpty()) {
			Passenger p = TicketBooking.waitingQueue.poll();
			p.setTicketType("RAC");
			TicketBooking.racQueue.offer(p);
		}
	}
	private static void racToConfirm() {
		if(!TicketBooking.racQueue.isEmpty()) {
			Passenger p = TicketBooking.racQueue.poll();
			p.setSeatNumber(seatNum);
			p.setPreference(pref);
			p.setTicketType("Confirmed");
			TicketBooking.confirmedList.add(p);
		}
	}
}
