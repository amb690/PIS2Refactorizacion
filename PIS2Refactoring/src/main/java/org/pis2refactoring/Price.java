package org.pis2refactoring;

public abstract class Price {
	public static final int RENTERPOINT = 1;
	
	protected abstract int getPriceCode();
	
	protected abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented){
       	return RENTERPOINT;
    }
}
