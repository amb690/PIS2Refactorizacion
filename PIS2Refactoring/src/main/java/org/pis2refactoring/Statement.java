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
	
	protected abstract String headerString(Customer aCustomer);
	
	protected abstract String eachRentalString(Rental aRental);
	
	protected abstract String footerString(Customer aCustomer);
}
