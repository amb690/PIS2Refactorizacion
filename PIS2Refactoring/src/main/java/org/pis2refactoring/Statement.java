package org.pis2refactoring;

import java.util.Enumeration;

public abstract class Statement {
	public String value(Customer aCustomer){
		Enumeration rentals = aCustomer.getRentals();
		StringBuilder stb = new StringBuilder();
        String result = headerString(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            stb.append(eachRentalString(each));
        }
        result+=stb.toString();
        result += footerString(aCustomer);
        return result;
	}
	
	public abstract String headerString(Customer aCustomer);
	
	public abstract String eachRentalString(Rental aRental);
	
	public abstract String footerString(Customer aCustomer);
}
