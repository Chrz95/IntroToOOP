// Χρήστος Ζαχαριουδάκης , 2014030056

public class Doctor {

	private String name ;
	private String specialty; 
	private static int numofDoctors = 0 ;
	private static int personal_code;
			
	Doctor ()
	{
			
	}	
	
	
	Doctor (String name,String specialty)
	{
		this.name = name ;
		this.specialty = specialty ; 
		personal_code = numofDoctors++ ;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getPersonal_code() {
		return personal_code;
	}

	
	
	
}
