package PIS2Refactoring.PIS2Refactoring;

import junit.framework.TestCase;

/**
 * Sample unit tests for the PIS2Refactoring project.
 */
public class PIS2RefactoringTest extends TestCase{
	private Customer customer;
	private Movie movie;
	private Rental rental;
	
	public void setUp() {
        this.customer = new Customer("Alberto");
        this.movie = new Movie("Godzilla", 5);
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
