package org.pis2refactoringtest;

import org.pis2refactoring.Customer;
import org.pis2refactoring.Movie;
import org.pis2refactoring.RegularPrice;
import org.pis2refactoring.Rental;

import junit.framework.TestCase;

/**
 * Sample unit tests for the PIS2Refactoring project.
 */
public class PIS2RefactoringTest extends TestCase{
	private Customer customer;
	private Movie movie;
	private Rental rental;
	private RegularPrice price;
	
	public void setUp() {
		price = new RegularPrice();
        this.customer = new Customer("Alberto");
        this.movie = new Movie("Godzilla", price);
        this.rental = new Rental(movie, 12);
    }
	
	public void testCreateMovie() {
        assertEquals("Godzilla", this.movie.getTitle());
    }
	
	public void testPriceMovie() {
        assertEquals(5, this.movie.getPriceCode());
    }
	
	public void testCreateCustomer() {
        assertEquals("Alberto", this.customer.getName());
    }
	
	public void testCreateRental() {
        assertEquals(this.movie, this.rental.getMovie());
    }
	
	public void testDaysRental() {
        assertEquals(12, this.rental.getDaysRented());
    }
}
