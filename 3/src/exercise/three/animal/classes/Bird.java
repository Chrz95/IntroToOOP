// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

public class Bird extends Animal 
{
	private String feather_color ; 
	public Bird (String name,String SerialRegistrationNumber,String color)
	{		
		super(name,SerialRegistrationNumber);
		feather_color = color ;
	}
	public String getFeather_color() {
		return feather_color;
	}
	
	public String toPrint() 
	{		
		return (super.toPrint() + "\nIt is a bird.\n" + "Feather Color : " + feather_color);
	}	
	
}
	
	

	
	
	
	

