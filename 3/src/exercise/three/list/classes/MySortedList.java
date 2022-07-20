// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.list.classes;

public class MySortedList extends SortedList {
		
	public void printAllInHierarchy(String className)
	{					
			 for (node tmp = head; tmp != null;  tmp = tmp.getNext())								 
				 	if (tmp.getValue().key().getClass().getName().equals(className)) // Serpent , Bird , Fish , Assistant , Trainer
				 		System.out.println(tmp.getValue().toString()) ;
	}		
}
