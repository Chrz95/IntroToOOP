// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

public class Animal 
{	
	protected String name , SerialRegistrationNumber ;	
	
	public Animal ()
	{
		this.name = null; 
		this.SerialRegistrationNumber = null ; 
	}	
	
	
	public Animal (String name,String SerialRegistrationNumber)
	{
		this.name = name; 
		this.SerialRegistrationNumber = SerialRegistrationNumber ; 
	}		
	
	public Animal (String SerialRegistrationNumber)
	{ 
		this.name = null ; 
		this.SerialRegistrationNumber = SerialRegistrationNumber ; 
	}	

	public String getSerialRegistrationNumber() {
		return SerialRegistrationNumber;
	}

	public String getName() {
		return name;
	}
		
	public String toPrint() {
		return ("\nName : " + name + "\nRegistration Number : " + SerialRegistrationNumber);
	}
}
