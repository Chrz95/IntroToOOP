// Χρήστος Ζαχαριουδάκης , 2014030056

public class Patient {

	private String name;
	private String amka;
		
	Patient ()
	{
		name = null ;
		amka = null;	
	}	
		
	Patient (String name,String amka)
	{
		this.name = name ;
		this.amka = amka ;		
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmka() {
		return amka;
	}
	public void setAmka(String amka) {
		this.amka = amka;
	}
	
	
	
}
