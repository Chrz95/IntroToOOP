// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.list.classes;
import exercise.three.employee.classes.* ;

public class EmployeeItem extends Item 
{
	
	private Employee em ; 
	
	public EmployeeItem(Employee em) { this.em = em; }
	
	public boolean equals(Item k)
	 {		
		 if (em.getAFM().equals(((Employee)k.key()).getAFM())) return true;
		 else return false;		 
	 } 
	
	 public Object key() // Επιστρέφει τα δεδομένα
	 {	
		 return em  ;
	 }	
	 
	 public String toString() 
	 {
		 return (em.toPrint() );
	 }
	
	 public boolean less(Item o) 
	 {
		    if (em.getAFM().compareTo(((Employee)o.key()).getAFM()) < 0)    return true;
		    return false;
	 }
	 

	 
}