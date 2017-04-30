package org.pis2refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Customer {
	   private String name;
	   private ArrayList<Rental> rentals = new ArrayList<Rental>();
	   public Customer (String name){
	       this.name = name;
	   }
	   
	   public void addRental(Rental rental) {
	     this.rentals.add(rental);
	   }
	   
	   public String getName (){
	       return this.name;
	   }
	   
	   public String statement() {
          return new TextStatement().value(this);
      }
	   
	  public String htmlStatement(){
		  return new HtmlStatement().value(this);
	  }
	   
	  public double getTotalCharge(){
		  double result=0;
		  Enumeration rentale = Collections.enumeration(this.rentals);
		  while (rentale.hasMoreElements()){
			  Rental each = (Rental) rentale.nextElement();
			  result += each.getCharge();
		  }
		  return result;
	  }
	  
	  public int getTotalFrequentRenterPoints(){
		  int result=0;
		  Enumeration rentale = Collections.enumeration(this.rentals);
		  while (rentale.hasMoreElements()){
			  Rental each = (Rental) rentale.nextElement();
			  result += each.getFrequentRenterPoints(each.getMovie().getPriceCode());
		  }
		  return result;
	  }
	  
	  public Enumeration getRentals(){
		  return Collections.enumeration(this.rentals);
	  }
}
