package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number : ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("checkout date (dd/MM/yyyy) : ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkIn)) {
			System.out.println("Error in reservation : checkout date must be after checkin date  ");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkout);
			System.out.println("Reservation : " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation : ");

			System.out.print("check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("checkout date (dd/MM/yyyy) : ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkout.before(now)) {
				System.out.println("Error in Reservation : reservation dates for update must be futures date ");
			}
			else if (!checkout.after(checkIn)) {
				System.out.println("Error in reservation : checkout date must be after checkin date  ");
			}
			else {
			reservation.updateDates(checkIn, checkout);
			System.out.println("Reservation : " + reservation);
			}
		}

		sc.close();
	}

}
