// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.list.classes;

public abstract class Item {
	abstract public boolean equals(Item k);	
	abstract public Object key();  // Επιστρέφει τα δεδομένα	
	abstract boolean less(Item a) ;
	abstract public String toString() ;
}
