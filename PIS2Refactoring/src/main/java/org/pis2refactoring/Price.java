package org.pis2refactoring;

public abstract class Price {
	public static final int RENTERPOINT = 1;
	abstract int getPriceCode();
	
	abstract double getCharge(int daysRented);
	
	int getFrequentRenterPoints(int daysRented){
       	return RENTERPOINT;
    }
}
