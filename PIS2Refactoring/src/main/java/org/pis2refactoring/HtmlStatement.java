package org.pis2refactoring;

import java.util.Enumeration;

public class HtmlStatement extends Statement{
	@Override
	public String value(Customer aCustomer){
		Enumeration<Rental> rentals = aCustomer.getRentals();
		StringBuilder stb = new StringBuilder();
	  	String result = headerString(aCustomer);
	    while (rentals.hasMoreElements()) {
	    	Rental each = rentals.nextElement();
	    	stb.append(eachRentalString(each));
        }
	    result+=stb.toString();
        //add footer lines
        result += footerString(aCustomer);
		  return result;
	}
	
	@Override
	public String headerString(Customer aCustomer){
		return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
	}
	
	@Override
	public String eachRentalString(Rental aRental){
		return "\t" + aRental.getMovie().getTitle()+ ": " + aRental.getMovie().getTitle() + ": " + aRental.getCharge() + "<BR>\n";
	}
	
	@Override
	public String footerString(Customer aCustomer){
		return "<P>You owe <EM>" + aCustomer.getTotalCharge() + "</EM><P>\n" 
	+ "On this rental you earned <EM>" + aCustomer.getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
	}
}
