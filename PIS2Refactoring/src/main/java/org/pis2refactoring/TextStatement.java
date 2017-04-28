package org.pis2refactoring;

import java.util.Enumeration;

public class TextStatement extends Statement{
	@Override
	public String value(Customer aCustomer){
		Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }
        result += footerString(aCustomer);
        return result;
	}
	
	public String headerString(Customer aCustomer){
		return "Rental Record for " + aCustomer.getName() + "\n";
	}
	
	public String eachRentalString(Rental aRental){
		return "\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n";
	}
	
	public String footerString(Customer aCustomer){
		return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n"
         + "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
	}
}
