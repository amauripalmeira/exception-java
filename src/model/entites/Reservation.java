package model.entites;

import java.text.SimpleDateFormat;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.domainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkout;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer rumNumber, Date chekinIn, Date checkout)  {
		if (!checkout.after(checkIn)) {
			throw new domainException(" : checkout date must be after checkin date  " );
		}
		this.roomNumber = rumNumber;
		this.checkIn = chekinIn;
		this.checkout = checkout;
	}

	public Integer getRumNumber() {
		return roomNumber;
	}

	public void setRumNumber(Integer rumNumber) {
		this.roomNumber = rumNumber;
	}

	public Date getChekinIn() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		/* se faz checkout - checkin para nao dar um valor negativo */
		long dff = checkout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dff, TimeUnit.MILLISECONDS);
	}

	public void   updateDates(Date checkIn, Date checkout) {
		
		Date now = new Date();

		if (checkIn.before(now) || checkout.before(now)) {
			throw new domainException( " : reservation dates for update must be futures date " );
		}
		if (!checkout.after(checkIn)) {
			throw new domainException(" : checkout date must be after checkin date  " );
		}
		this.checkIn = checkIn;
		this.checkout = checkout;
		
		
	}

	@Override
	public String toString() {
		return " Romm " + " , check -in : " + sdf.format(checkIn) + " , check -out " + sdf.format(getCheckout()) + " , "
				+ duration() + " nights ";

	}

}
