package org.pis2refactoring;

import java.util.Enumeration;

public class HtmlStatement extends Statement{
	@Override
	public String value(Customer aCustomer){
		Enumeration<Rental> rentals = aCustomer.getRentals();
		  String result = headerString(aCustomer);
		  while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }
        //add footer lines
        result += footerString(aCustomer);
		  return result;
	}
	
	public String headerString(Customer aCustomer){
		return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
	}
	
	public String eachRentalString(Rental aRental){
		return "\t" + aRental.getMovie().getTitle()+ ": " + aRental.getMovie().getTitle() + ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
	}
	
	public String footerString(Customer aCustomer){
		return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" 
	+ "On this rental you earned <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
	}
}
