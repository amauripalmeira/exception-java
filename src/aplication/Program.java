package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;
import model.exceptions.domainException;

public class Program {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
		try {
			
		System.out.print("Room Number : ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("checkout date (dd/MM/yyyy) : ");
		Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkout);
			System.out.println("Reservation : " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation : ");

			System.out.print("check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("checkout date (dd/MM/yyyy) : ");
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkout);
		    System.out.println("Reservation " + reservation );
			
		}catch(ParseException e ) {
			System.out.println("invalid date format ");
		} 
		catch(domainException e) {
			System.out.println("Error in reservation " + e.getMessage() );
		}
		catch(RuntimeException e ){
			System.out.println("unexpected error ");
		}

		sc.close();
	}

}
