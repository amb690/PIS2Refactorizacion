package org.pis2refactoring;

import java.util.Enumeration;

public class TextStatement extends Statement{
	@Override
	public String value(Customer aCustomer){
		Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        StringBuilder stb = new StringBuilder();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            stb.append(eachRentalString(each));
        }
        result+=stb.toString();
        result += footerString(aCustomer);
        return result;
	}
	
	@Override
	public String headerString(Customer aCustomer){
		return "Rental Record for " + aCustomer.getName() + "\n";
	}
	
	@Override
	public String eachRentalString(Rental aRental){
		return "\t" + aRental.getMovie().getTitle()+ "\t" + aRental.getCharge() + "\n";
	}
	
	@Override
	public String footerString(Customer aCustomer){
		return "Amount owed is " + aCustomer.getTotalCharge() + "\n"
         + "You earned " + aCustomer.getTotalFrequentRenterPoints() + " frequent renter points";
	}
}
