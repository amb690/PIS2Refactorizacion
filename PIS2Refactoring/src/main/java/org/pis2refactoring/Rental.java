package org.pis2refactoring;

public class Rental {
    private Movie movie;
    private int daysRented;
    
    public Rental(Movie movie, int daysRented) {
      this.movie = movie;
      this.daysRented = daysRented;
    }
    
    public int getDaysRented() {
      return this.daysRented;
    }
    
    public Movie getMovie() {
      return this.movie;
    } 

    double getCharge(){
    	return this.movie.getCharge(this.daysRented);
    }
    
    int getFrequentRenterPoints(int daysRented){
        if ((this.movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
        	return 2;
        else
        	return 1;
    }
}
