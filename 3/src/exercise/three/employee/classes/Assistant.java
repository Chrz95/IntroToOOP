// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.employee.classes;

import tuc.ece.cs102.util.StandardInputRead;

public class Assistant extends Employee {
	
	String department ; 
	public Assistant (String name,String AFM)
	{
		super(name,AFM);
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String toPrint() 
	{		
		return (super.toPrint() + "\nWorks at the " +  department + " department");
	}	
	
	public void setDepartment() {
			
		boolean check = false ;	
		
			System.out.println("The assistants can work at the following departments :\n ");
			System.out.println("1.Cash Desk");
			System.out.println("2.Security");
			System.out.println("3.Refreshments\n");
			
			do 
			{	
			
				do
				{
				   choice = Reader.readPositiveInt("Choose the department this assistant works : ") ;
					if (choice == StandardInputRead.POS_ERROR )			
						System.out.println("Error.Input a positive integer!");			
				} while (choice == StandardInputRead.POS_ERROR);	
				
				
				switch (choice)
				{
					case 1 :
						department = "cash desk" ; 
						check = true ;
						break ;
					case 2 :
						department = "security" ;
						check =  true ;
						break ;
					case 3 :
						department = "refreshments" ;	
						check =  true ;
						break ;
					default :
						System.out.println("Choose one of the above options!");
						check =  false ;
						break ;
				}
	
			} while (check == false) ; 
}

}
