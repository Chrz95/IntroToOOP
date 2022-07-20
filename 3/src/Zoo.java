// Χρήστος Ζαχαριουδάκης ,2014030056

import exercise.three.list.classes.MySortedList;

public class Zoo 
{
	private String name ; 
	private String city ;
	private MySortedList listOfEmployees, listOfAnimals  ;
		
	public Zoo (String name, String city)
	{
		this.name = name ; 
		this.city = city ; 
		listOfEmployees = new MySortedList();
		listOfAnimals = new MySortedList() ;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}

	public MySortedList getListOfEmployees() {
		return listOfEmployees;
	}

	public MySortedList getListOfAnimals() {
		return listOfAnimals;
	}
	
	
	
	
	
	

}
