// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.employee.classes;

import tuc.ece.cs102.util.StandardInputRead;

public class Employee {
	
	protected StandardInputRead Reader = new StandardInputRead ();
	protected int choice ; 
	protected String name , AFM ; 
	
	public Employee ()
	{
		this.name = null; 
		this.AFM = null ; 
	}	
	
	public Employee (String name,String AFM)
	{
		this.name = name ; 
		this.AFM = AFM ; 
	}
	
	
	public Employee (String AFM)
	{
		this.name = null ; 
		this.AFM = AFM ; 
	}

	public String getName() {
		return name;
	}

	public String getAFM() {
		return AFM;
	}
	
	
	public String toPrint() {
		return ("\nName : " + name + "\nAFM : "+ AFM);
	}
	
	
	

}
