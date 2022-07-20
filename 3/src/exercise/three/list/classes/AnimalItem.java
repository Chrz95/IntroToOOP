// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.list.classes;
import exercise.three.animal.classes.*;

public class AnimalItem extends Item {
	
	private Animal an ;	
	
	public AnimalItem(Animal an) { this.an = an; }
	
	 public boolean equals(Item k)
	 {
		 if (an.getSerialRegistrationNumber().equals(((Animal)k.key()).getSerialRegistrationNumber())) return true;
		 else return false;
	 }	 
	 
	 public Object key()  // Επιστρέφει τα δεδομένα
	 {	
		 return an  ;
	 }
	
	 public String toString() 
	 {
		 return (an.toPrint());
	 }
	
	 public boolean less(Item o) 
	 {
		    if (an.getSerialRegistrationNumber().compareTo(((Animal)o.key()).getSerialRegistrationNumber()) < 0) return true;
		    return false;
	 }		 
	
}
