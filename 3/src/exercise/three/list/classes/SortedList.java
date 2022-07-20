package exercise.three.list.classes;

public class SortedList extends list {
	
	
	
	
	  public node insert (Item a) {                         // Επιστρέφει την κεφαλή
	    node tmp = new node(a);     length++;
	    node n1 = head, n2 = head;

	    // Εδώ θα είναι χρήσιμη η μέθοδος σύγκρισης less
	    while ((n1 != null) && (n1.getValue().less(a) )) {  // Αναζητούμε τους 2 κόμβους μεταξύ
	      n2 = n1;   n1 = n1.getNext();  }                          // των οποίων θα γίνει η εισαγωγή
	    if (n1 == head) {                                                  // Εάν γίνεται εισαγωγή στην αρχή...
	      tmp.setNext(n1); head = tmp;
	    }
	    else {                    // Εισαγωγή μεταξύ n1 και n2. Καλύπτει και την εισαγωγή στο τέλος
	      n2.setNext(tmp);
	      tmp.setNext(n1);   
	    } 
	    return head;
	  } 
	}

    
    
    
    

