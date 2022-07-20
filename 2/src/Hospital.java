// Χρήστος Ζαχαριουδάκης , 2014030056

public class Hospital {
	
	private String name ;  
	private String[] departments = new String[100] ;
	private Doctor[] listOfDoctors = new Doctor[100] ;
	private Patient[] listOfPatients = new Patient[100] ;
	private PatientDocument[] listOfDocuments = new PatientDocument[100] ;
	private Examination[] listOfExams = new Examination[100] ;
	private final int RegistrationsLimit = 100 ;	
	private static int numOfDepartments = 0 ;
	private static int numOfDoctors = 0 ;
	private static int numOfPatients = 0 ;
	private static int numOfDocuments = 0 ;	
	private static int numOfExams = 0 ;	
	
	Hospital ()
	{;}
	
	Hospital (String name,String[] departments)
	{
		this.name = name;
		this.departments = departments;
		
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
		
	public void addDepartments (String name)
	{
		if (numOfDepartments == RegistrationsLimit)
		{
			System.out.println("You have entered the maximum number of departments:" + RegistrationsLimit);			
			return;
		}
		else departments[numOfDepartments++] = name ;		 
	}
	
	public void printDepartments ()
	{
		System.out.println ("The hospital departments are :");
		for (int i = 0 ; i < numOfDepartments ; i++)		
			System.out.println (departments[i]);		
	}
	
	public String [] getDepartments ()
	{
		return departments ;	
	}
	
	public void setDepartments (String[] departments )
	{
		this.departments = departments ;	
	}
	
	public void addExams (String name)
	{
		if (numOfExams == RegistrationsLimit)
		{
			System.out.println("You have entered the maximum number of exams:" + RegistrationsLimit);			
			return;
		}
		else listOfExams[numOfExams++] = new Examination (name) ;
	}

	public void addDoctors (Doctor doctor)
	{	
		if (numOfDoctors == RegistrationsLimit)
		{
			System.out.println("You have entered the maximum number of doctors:" + RegistrationsLimit);			
			return;
		}
		else listOfDoctors[numOfDoctors++] = new Doctor (doctor.getName(),doctor.getSpecialty()) ; 
	}
	
	public void addPatients (Patient patient)
	{
		if (numOfPatients >= RegistrationsLimit)
		{
			System.out.println("You have entered the maximum number of patients:" + RegistrationsLimit);			
			return;
		}
		else listOfPatients[numOfPatients++] = new Patient (patient.getName(),patient.getAmka()) ; 
	}	
	
	public void addDocuments (PatientDocument document)
	{
		if (numOfDocuments == RegistrationsLimit)
		{
			System.out.println("You have entered the maximum number of documents:" + RegistrationsLimit);			
			return;				
		}
		listOfDocuments[numOfDocuments] = new PatientDocument () ; 
		listOfDocuments[numOfDocuments++] = document;		
	}

	public Doctor[] getListOfDoctors()
	{
		return listOfDoctors;
	}	

	public int getNumOfExams() {
		return numOfExams;
	}
	
	public int getNumOfDepartments() {
		return numOfDepartments;
	}
	
	public Patient[] getListOfPatients() {
		return listOfPatients;
	}

	public PatientDocument[] getListOfDocuments() {
		return listOfDocuments;
	}

	public Examination[] getListOfExams() 
	{
		return listOfExams;
	}

	public int getNumOfDoctors() {
		return numOfDoctors;
	}
	
	public void deletePatient(Patient patient) 
	{  
		int i =0 ;		
		 while ((listOfPatients [i] !=null) && (i < numOfPatients))
		 {
			 if (listOfPatients[i].equals(patient))
			 {
				 for(int j = i; j < numOfPatients - 1; j++)				 
					 listOfPatients[j] = listOfPatients[j+1] ;					
				 
				 listOfPatients[numOfPatients-1] = null ; 
				 numOfPatients-- ;
			 }
			 i++ ; 
		 }
	}
	
	public void deleteDocument(PatientDocument document) 
	{  
		int i =0 , j = 0 ;		
		 while (listOfDocuments [i] !=null)
		 {
			 if (listOfDocuments[i].equals(document))
			 {
				 j = i ; 
				 while (listOfDocuments [j] !=null)
				 {
					 listOfDocuments[j] = listOfDocuments[j+1] ;
					 j++;
				 }
				 listOfDocuments[numOfDocuments-1] = null ; 
				 numOfDocuments-- ;
			 }
			 i++ ; 
		 }
		}

	public int getNumOfPatients() {
		return numOfPatients;
	}
	
	public int getNumOfDocuments() {
		return numOfDocuments;
	}

	public static void setNumOfDepartments(int numOfDepartments) {
		Hospital.numOfDepartments = numOfDepartments;
	}

	public static void setNumOfDoctors(int numOfDoctors) {
		Hospital.numOfDoctors = numOfDoctors;
	}

	public static void setNumOfPatients(int numOfPatients) {
		Hospital.numOfPatients = numOfPatients;
	}

	public static void setNumOfDocuments(int numOfDocuments) {
		Hospital.numOfDocuments = numOfDocuments;
	}

	public static void setNumOfExams(int numOfExams) {
		Hospital.numOfExams = numOfExams;
	}

	}


	

	

