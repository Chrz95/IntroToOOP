// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

import tuc.ece.cs102.util.StandardInputRead;

abstract public class Serpent extends Animal {

	private StandardInputRead Reader = new StandardInputRead ();
	private int choice ; 
	
	protected String skin_covering ; 
	public Serpent (String name,String SerialRegistrationNumber)
	{		
		super(name,SerialRegistrationNumber);		
	}
	
	public Serpent ()
	{		
		super();
		skin_covering = null; 
	}
	
	public String getSkin_covering() {
		return skin_covering;
	}	
	
	
	public String toPrint() 
	{		
		return (super.toPrint() + "\nIt is a serpent.\n" + "Skin covering : " + skin_covering);
	}

	public void setSkin_covering() {
		
		boolean check ; 
		
		System.out.println("The serpents can have the following types of skin :\n ");
		System.out.println("1.Plates");
		System.out.println("2.Scales");
		System.out.println("3.Flakes\n");
		
		do
		{	
		
			do
			{
			   choice = Reader.readPositiveInt("Choose the type of skin this serpent has : ") ;
				if (choice == StandardInputRead.POS_ERROR )			
					System.out.println("Error.Input a positive integer!");			
			} while (choice == StandardInputRead.POS_ERROR);	
			
			
			switch (choice)
			{
				case 1 :
					skin_covering = "plates" ; 
					check = true ;
					break ;
				case 2 :
					skin_covering = "scales" ;
					check =  true ;
					break ;
				case 3 :
					skin_covering = "flakes" ;	
					check =  true ;
					break ;
				default :
					System.out.println("Choose one of the above options!");
					check =  false ;
					break ;
			}
		
		} while (check == false );
		
		
		
		
		
	}		
	
	
	
	
	
}
