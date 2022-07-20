// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.list.classes;

public class node {
	  private Item info;
	  private node next;

	  public node(Item dat) 
	  { 
		  info = dat; 
	  }     
	  
	  public node(Item dat, node b) 
	  {
	    info = dat;  next = b;
	  }

	  public Item     getValue()          { return info;  }   // Θα κληθεί συχνά
	  public void     setNext(node a)  { next = a;     }
	  public node    getNext()            { return next; }
}
