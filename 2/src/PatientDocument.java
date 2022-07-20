// Χρήστος Ζαχαριουδάκης , 2014030056

import java.util.Date;

public class PatientDocument {

	private Hospital hospital= new Hospital ()  ; 
	private Patient patient = new Patient ()  ; 
	private Doctor doctor = new Doctor() ;
	private Date importDate , exportDate ;	
	private Examination[] listOfExams = new Examination[5] ; 	
	private Date[] listOfDates = new Date[5];
	private final int limitExams = 5 ; 
	private static int num_of_exams = 0  ; 
	
	PatientDocument ()
	{
		
	}
	
	PatientDocument (Hospital hosp1,Patient pt1,Doctor doc,Date importDate,Date exportDate,int num_of_exams)
	{
		hospital = hosp1 ;
		patient = pt1 ;
		doctor = doc ; 		
		this.importDate = importDate ;
		this.exportDate = exportDate ;		
	}	
	
	public void addPatientExams (Examination exam,Date exam_date)
	{
		if (num_of_exams == limitExams)
		{
			System.out.println("You have entered the maximum number of examinations:" + limitExams);			
			return;
		}
		else
		listOfExams[num_of_exams] = exam ; 
		listOfDates[num_of_exams++] = exam_date ; 		
	}			

	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public Date getExportDate() {
		return exportDate;
	}
	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date[] getListOfDates() {
		return listOfDates;
	}

	public void setListOfDates(Date[] listOfDates) {
		this.listOfDates = listOfDates;
	}

	public Examination[] getListOfExams() {
		return listOfExams;
	}

	public void setListOfExams(Examination[] listOfExams) {
		this.listOfExams = listOfExams;
	}

	public int getNum_of_exams() {
		return num_of_exams;
	}
	
	public int getLimitExams() {
		return limitExams;
	}

	public boolean printPatientDocument (String amka,Date in_date,Date out_date)
	{
		boolean found = false ; 
		for (int i=0 ; i < hospital.getNumOfPatients() ; i++)
		{			
			if  ((hospital.getListOfPatients()[i].getAmka().equals(amka))) 
			{
				if ((importDate.compareTo(in_date) >= 0 ) && (exportDate.compareTo(out_date)<= 0  ))
				{
					found = true ; 
					System.out.println ("\nThe patient folder has the following contents:\n");
					System.out.println ("Patient :");
					System.out.println ("Name : "+ patient.getName()) ;
					System.out.println ("Amka : "+ patient.getAmka()) ;
				    System.out.println ("Import Date : "+ importDate) ;
					System.out.println ("Export Date : "+ exportDate) ;							
					System.out.println ("\nDoctor :");
					System.out.println ("Code : "+ doctor.getPersonal_code()) ; 
					System.out.println ("Name : "+ doctor.getName() ) ;
					System.out.println ("Specialty : "+ doctor.getSpecialty() ) ;
							
					System.out.println ("The patient was subjected to the following examinations at the respective dates : \n");							
												
					for (int w =0 ; w < num_of_exams ; w++ )
					{
						System.out.println ("Exam name : " + listOfExams[w].getName());
						System.out.println ("Exam date : " + listOfDates[w] + "\n");
					}
				}
			}
		}
		if (found == true) return true; else return false ; 
	}
	
	
	
	
	
	
}
