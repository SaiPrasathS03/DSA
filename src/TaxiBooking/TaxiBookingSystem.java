package TaxiBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingSystem {
	static Scanner sc = new Scanner(System.in);
	static List<Taxi> taxiList = new ArrayList<>();
	public static void main(String[] args) {
		
		System.out.println("Enter the number of taxis: ");
		int taxis = Integer.parseInt(sc.nextLine());
		for(int i=1;i<=taxis;i++) {
			taxiList.add(new Taxi(i));
		}
		boolean loop = true;
		while (loop) {
			System.out.println("1. Book Taxi\n2. View Taxi Details\n3. Exit");
			int choice = 0;
			try {
				System.out.println("Enter your choice");
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("-----Enter valid choice-----");
			}

			switch (choice) {
			case 1:
				bookTaxi();
				break;
			case 3:
				loop=false;
				break;
			default:
				System.out.println("-----Enter valid choice-----");
			}
		}
	}

	private static void bookTaxi() {
		String origin = getOrigin();
		String destination = getDestination();
		int pickupTime = getPickupTime();
		int crctTime = pickupTime+Math.abs(origin.charAt(0)-destination.charAt(0));
		int dropTime = crctTime<23?crctTime:24-crctTime;
		int distance = 15*Math.abs(origin.charAt(0)-destination.charAt(0));
		int amount = 100+((distance-5)*10);
		Booking booking = new Booking(origin, destination, pickupTime, dropTime, amount);
		Taxi bookedTaxi = taxiToBeBooked(booking);
		if(bookedTaxi==null) {
			System.out.println("No Taxis available");
			return;
		}
		bookedTaxi.addEarnings(bookedTaxi,amount);
		bookedTaxi.setCurrentLoc(destination);
		bookedTaxi.getBookings().add(booking);
		System.out.println("\nTaxi-"+bookedTaxi.getId()+" booked successfully");
		System.out.println();
		displayAllTaxis();
		
	}


	private static void displayAllTaxis() {
		for(Taxi taxi:taxiList) {
			System.out.println("Taxi-"+taxi.getId()+" details");
			taxi.displayDetails(taxi);
		}
	}

	private static Taxi taxiToBeBooked(Booking booking) {
		Taxi taxiBooked = null;
		int minDistance = 1000;
		int minEarnings = Integer.MAX_VALUE;
		String pickup = booking.getOrigin();
		for(Taxi taxi:taxiList) {
			int distance = Math.abs(taxi.getCurrentLoc().charAt(0)-pickup.charAt(0));
				if(taxi.isAvailable(booking.getPickupTime()) && (distance<minDistance || (distance==minDistance && taxi.getEarnings()<minEarnings))) {
					taxiBooked = taxi;
					minDistance = distance;
					minEarnings = taxi.getEarnings();
				}
		}
		return taxiBooked;
	}

	private static int getPickupTime() {
		int pickupTime = 0;
		try {
			do {
				System.out.println("Enter pickup time (0-23): ");
				pickupTime = Integer.parseInt(sc.nextLine());
				if(pickupTime<0 || pickupTime>23) {
					System.out.println("-----Enter valid pickup time (0-23)-----");
				}
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid pickup time (0-23)-----");
		}
		return pickupTime;
	}

	private static String getOrigin() {
		String org = "";
		try {
			do {
				System.out.println("Enter origin (A-F): ");
				org = sc.nextLine();
				if(!org.equalsIgnoreCase("A") && !org.equalsIgnoreCase("B") && !org.equalsIgnoreCase("C") &&
						!org.equalsIgnoreCase("D") && !org.equalsIgnoreCase("E") && !org.equalsIgnoreCase("F")) {
					System.out.println("-----Enter valid Origin(A-F)-----");
				}
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid Origin-----");
		}
		return org;
	}
	private static String getDestination() {
		String des = "";
		try {
			do {
				System.out.println("Enter origin (A-F): ");
				des = sc.nextLine();
				if(!des.equalsIgnoreCase("A") && !des.equalsIgnoreCase("B") && !des.equalsIgnoreCase("C") &&
						!des.equalsIgnoreCase("D") && !des.equalsIgnoreCase("E") && !des.equalsIgnoreCase("F")) {
					System.out.println("-----Enter valid Destination(A-F)-----");
				}
				else break;
			}while(true);
		}catch (Exception e) {
			System.out.println("-----Enter valid Destination-----");
		}
		return des;
	}
	

}
