// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.employee.classes;

import tuc.ece.cs102.util.StandardInputRead;

public class Trainer extends Employee {

	String training ; 
	public Trainer(String name,String AFM)
	{
		super(name,AFM);
	}
	
	public String getTraining() {
		return training;
	}
	
	public String toPrint() 
	{		
		return (super.toPrint() + "\nOffers '" +  training + "' training");
	}
	
	public void setTraining() {
			
			boolean check ;
		
			System.out.println("The trainers can offer the following :\n ");
			System.out.println("1.Dancing");
			System.out.println("2.Walking");
			System.out.println("3.Greeting\n");
			
			do
			{
				do
				{
				   choice = Reader.readPositiveInt("Choose the training this trainer offers : ") ;
					if (choice == StandardInputRead.POS_ERROR )			
						System.out.println("Error.Input a positive integer!");			
				} while (choice == StandardInputRead.POS_ERROR);	
				
				
				switch (choice)
				{
					case 1 :
						training = "dancing" ; 
						check = true ;
						break ;
					case 2 :
						training = "walking" ;
						check = true ;
						break ;
					case 3 :
						training = "greeting" ;	
						check = true ;
						break ;
					default :
						System.out.println("Choose one of the above options!");
						check = false ;
						break ;
				}
			
			}while (check == false);
	
}
	
}
