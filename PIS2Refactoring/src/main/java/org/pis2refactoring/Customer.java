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
		  StringBuilder stb = new StringBuilder();
		  Enumeration<Rental> rentale= Collections.enumeration(this.rentals);
		  String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		  while (rentale.hasMoreElements()) {
              Rental each = rentale.nextElement();
              stb.append("\t" + each.getMovie().getTitle()+ ": " + each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n");
          }
		  result+=stb.toString();
          //add footer lines
          result +=  "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
          result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
		  return result;
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
