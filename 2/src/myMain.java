// Χρήστος Ζαχαριουδάκης , 2014030056

import tuc.ece.cs102.util.StandardInputRead;
import java.util.Date;

public class myMain {
				
	public static void main(String[] args)
	{		   		 
		 final int limitHospitals = 2 ; 
		 int num_of_hospitals = -1 /*θα αυξηθεί με την πρώτη εκτέλεση του case 1 σε 0 */ , choice ,num_of_departments =0 ,num_of_exams=0, j=0 ,cnt = 0; 
		 boolean found = false , correct_input= false  ;
		 Hospital[] listOfHospitals = new Hospital[2] ;
		 Doctor[] listOfInputedDoctors = new Doctor[200] ; // Για έλεγχο διπλότυπων σε γιατρούς
		 StandardInputRead Reader = new StandardInputRead();
		 Hospital tempHospital = new Hospital(); // Προσωρινά αντικείμενα για αποθήκευση δεδομένων , πριν αυτά αποθηκευτουν στις λίστες
		 Examination tempExam =new Examination()  ;
		 Doctor tempDoctor = new Doctor() ; 
		 Patient tempPatient = new Patient () ; 
		 PatientDocument tempDocument = new PatientDocument();	 
		 String search_amka,temp_string ;
		 Date temp_date,search_in_date , search_out_date ; 

		while (true)
		{	
			System.out.println ("\n1.Enter hospital data."); // Κεντρικό μενού
			System.out.println ("2.Enter examination data.");
			System.out.println ("3.Enter doctor data.");
			System.out.println ("4.Enter patient data.");
			System.out.println ("5.Enter a patient input form.");
			System.out.println ("6.Delete a patient.");
			System.out.println ("7.Find a patient input form and print it");
			System.out.println ("8.Print all the data of exams,hospitals,patients or input forms");
			System.out.println ("Input any other number in order to Exit.\n");
			
			do
			{
			   choice = Reader.readPositiveInt("Input the respective number of the option you want: ") ;
				if (choice == StandardInputRead.POS_ERROR ) 			
					System.out.println("Error.Try again.");				
			} while (choice == StandardInputRead.POS_ERROR);
			
			switch (choice) // Επιλογές μενού
			{
			case (1): // Εισαγωγή στοιχείων νοσοκομείου				
				if (num_of_hospitals == limitHospitals) // Περίπτωση που προσπαθεί να εισάγει παραπάνω απο δυό νοσοκομεία				
					System.out.println("You have entered the maximum number of hospitals:" + limitHospitals);
			    else
				{
			    	num_of_hospitals++; // ’υξηση του αριθμού των υπάρχοντων νοσοκομείων
			    	
					do // Εισαγωγή ονόματος νοσοκομείου
					{
						tempHospital.setName(Reader.readString("Enter the name of the hospital : ")) ;
						if (tempHospital.getName() == null ) 			
							System.out.println("Error.Try again.");				
					} while (tempHospital.getName() == null);				
								
					do // Εισαγωγή τμημάτων νοσοκομείου
					{						
						num_of_departments = Reader.readPositiveInt("How many departments does the hospital have? ") ;						
						if (num_of_departments == StandardInputRead.POS_ERROR )     			
							System.out.println("Error.Try again.");	
						if (num_of_departments == 0)
							System.out.println("A hospital cannot have no departments.Try again.");
						if (num_of_departments > 100)
							System.out.println("A hospital cannot have more than 100 departments.Try again.");
					} while ((num_of_departments == StandardInputRead.POS_ERROR) | (num_of_departments == 0) | (num_of_departments > 100)) ;					
										
					for (int i=0; i< num_of_departments ; i++) // Εισαγωγή των τμημάτων του νοσοκομείου
					{							
						do
						{	
							tempHospital.addDepartments(Reader.readString("Enter the name of the department : ")) ;
							if (tempHospital.getDepartments()[i] == null ) 			
								System.out.println("Error.Try again.");				
						} while (tempHospital.getDepartments()[i] == null);	
						
						listOfHospitals[num_of_hospitals] = new Hospital (tempHospital.getName(),tempHospital.getDepartments());
						if (num_of_hospitals == 1) 
							{
								listOfHospitals[num_of_hospitals].setNumOfDoctors(0);
								listOfHospitals[num_of_hospitals].setNumOfDocuments(0);
								listOfHospitals[num_of_hospitals].setNumOfPatients(0);
								listOfHospitals[num_of_hospitals].setNumOfExams(0);		
							}
					}					
				}				
				break ;
				
			case (2): // Εισαγωγή εξέτασης
				if (listOfHospitals[0] != null) // Αν υπάρχει τουλάχιστον ένα νοσοκομείο
				{					
					do
					{
						tempExam.setName(Reader.readString("Enter the name of the examination : ")) ;
						if (tempExam.getName() == null ) 			
							System.out.println("Error.Try again.");				
					} while (tempExam.getName() == null);	
					
					listOfHospitals[num_of_hospitals].addExams(tempExam.getName());					
				}
				else System.out.println ("Error! You must enter a hospital first! To do so , enter 1.") ;					
				break ;
			case (3): // Εισαγωγή ιατρού				 
				if (listOfHospitals[0] != null) // Αν υπάρχει τουλάχιστον ένα νοσοκομείο
				{									
					do // Εισαγωγή του ονόματος και της ειδικότητας του γιατρού στο προσωρινό αντικείμενο
					{
						tempDoctor.setName(Reader.readString("Enter the doctor's name : "));
						tempDoctor.setSpecialty(Reader.readString("Enter the doctor's specialty : "));
						if ( (tempDoctor.getName() == null ) || (tempDoctor.getSpecialty() == null ) ) 			
							System.out.println("Error.Try again.");				
					} while ((tempDoctor.getName() == null ) || (tempDoctor.getSpecialty() == null ));	
					
					found = false ; //Ελεγχος για διπλότυπους γιατρούς
					if (cnt == 0)
					{
						listOfInputedDoctors[0]= new Doctor (tempDoctor.getName(),tempDoctor.getSpecialty());
						cnt = 1 ; 						 
					}
					else
					{
						for (int i = 0 ; i < cnt; i++ )						
							if ((listOfInputedDoctors[i].getSpecialty().equals(tempDoctor.getSpecialty())) && (listOfInputedDoctors[i].getName().equals(tempDoctor.getName())))							
								found = true;	
					}
						if (!found) 
						{
								listOfInputedDoctors[cnt++]= new Doctor (tempDoctor.getName(),tempDoctor.getSpecialty());
								listOfHospitals[num_of_hospitals].addDoctors(tempDoctor);
						}
						else System.out.println ("The doctor already works at one of the hospitals");
						
				}
				else System.out.println ("Error! You must enter a hospital first! To do so , enter 1.") ;					
				break ;
			case (4): // Εισαγωγή ασθενη			
				if (listOfHospitals[0] != null) // Αν υπάρχει τουλάχιστον ένα νοσοκομείο
				{					
					do
					{
						tempPatient.setName(Reader.readString("Enter the patient's name: "));
						tempPatient.setAmka(Reader.readString("Enter the patient's AMKA: "));
						if ((tempPatient.getName() == null ) || (tempPatient.getAmka() == null))			
							System.out.println("Error.Try again.");				
					} while ((tempPatient.getName() == null ) || (tempPatient.getAmka() == null));	
					
					listOfHospitals[num_of_hospitals].addPatients(tempPatient);				
				}
				else System.out.println ("Error! You must enter a hospital first! To do so , enter 1.") ;		
				break ;
			case (5): //Εισαγωγή φακέλου νοσηλείας ασθενούς				
				if (listOfHospitals[0] != null) // Αν υπάρχει τουλάχιστον ένα νοσοκομείο
				{	
					tempDocument.setHospital(null);
					tempDocument.setDoctor(null);
					do  // Εισαγωγή νοσοκομείου
					{						
						temp_string = Reader.readString("Enter the name of the hospital that the patient is in : ") ;
						for (int q = 0 ; (q < limitHospitals) && (listOfHospitals[q] != null) ; q++ )	
								if (listOfHospitals[q].getName().equals(temp_string)) tempDocument.setHospital(listOfHospitals[q]);	
						
						if (tempDocument.getHospital() == null) System.out.println("There is no hospital with that name.\nTry again");
					} while (tempDocument.getHospital() == null) ; 					
					
					if  ((tempDocument.getHospital().getListOfPatients()[0] != null) && (tempDocument.getHospital().getListOfDoctors()[0] != null) && (tempDocument.getHospital().getListOfExams()[0] != null)) 
					{ // Αν υπάρχει ένας τουλάχιστον ασθενής,γιατρος,εξέταση 						
						
						do  // Εισαγωγή αριθμού εξετάσεων του ασθενή
						{
							num_of_exams = Reader.readPositiveInt("How many times has the patient been examined ? ") ;
							if (num_of_exams == StandardInputRead.POS_ERROR )     			
								System.out.println("Error.Try again.");	
							if (num_of_exams == 0)
								System.out.println("A patient must have examined at least once.Try again.");								
							if (num_of_exams > 5)
								System.out.println("A patient is examined five times at most.You cannot enter more examinations.");
						} while ((num_of_exams == StandardInputRead.POS_ERROR) | (num_of_exams == 0) | (num_of_exams > 5)) ;					
					
						for (int i=0 ; i< num_of_exams ; i++) // Εισαγωγή num_of_exams εξετάσεων
						{
							do
							{	
								do 
								{
									tempExam = null ; 
									temp_string = Reader.readString("Enter the name of the examination : ");
									temp_date = Reader.readDate("Enter the date of the examination : " );
									if ( (temp_string == null ) | (temp_date == null ) ) 			
										System.out.println("Error.Try again.");				
								} while ((temp_string == null ) | (temp_date == null ));
							
								j=0;
								while (tempDocument.getHospital().getListOfExams()[j] !=null)
								{
									if (tempDocument.getHospital().getListOfExams()[j].getName().equals(temp_string))
										tempExam = tempDocument.getHospital().getListOfExams()[j]	;									
									j++; 
								}
								
								if (tempExam != null)tempDocument.addPatientExams(tempExam,temp_date);
								else System.out.println("There is no examination with that name.");	
							
							} while (tempExam == null);
						}
						
						do // Προσθήκη γιατρού
						{
							do 
							{
								tempDoctor = null ;
								temp_string = Reader.readString("Enter the doctor's name : ");							
								if (temp_string == null )			
									System.out.println("Error.Try again.");				
							} while (temp_string == null );
					
							j=0;
							while (tempDocument.getHospital().getListOfDoctors()[j] !=null)
							{
								if (tempDocument.getHospital().getListOfDoctors()[j].getName().equals(temp_string))
									tempDoctor = tempDocument.getHospital().getListOfDoctors()[j];	
								j++; 
							}
					
							if (tempDoctor != null) tempDocument.setDoctor(tempDoctor);
							else System.out.println("There is no doctor with that name.");	
					
						} while (tempDoctor == null);
							
						do // Προσθήκη ασθενή
						{
							do 
							{
								tempPatient = null ;
								temp_string = Reader.readString("Enter the patient's name : ");							
								if (temp_string == null )			
									System.out.println("Error.Try again.");				
							} while (temp_string == null );
					
							j=0;
							while (tempDocument.getHospital().getListOfPatients()[j] !=null)
							{
								if (tempDocument.getHospital().getListOfPatients()[j].getName().equals(temp_string))
									tempPatient = tempDocument.getHospital().getListOfPatients()[j];	
								j++; 
							}
					
							if (tempPatient != null) tempDocument.setPatient(tempPatient);
							else System.out.println("There is no patient with that name.");	
					
						} while (tempPatient == null);	
						
						do // Πρέπει η ημερομηνία εισαγωγής για είναι πίο πριν απο αυτή της εξαγωγής
						{	
							do // Ημερομηνία εισαγωγής 				
							{
								tempDocument.setImportDate(Reader.readDate("Enter the date that the patient was imported : ")) ;
								if (tempDocument.getImportDate() == null )		
									System.out.println("Error.Try again.");				
							} while (tempDocument.getImportDate() == null );
						
							do // Ημερομηνία εξαγωγής			
							{
								tempDocument.setExportDate(Reader.readDate("Enter the date that the patient was allowed to leave : "));
								if (tempDocument.getExportDate() == null )		
									System.out.println("Error.Try again.");				
							} while (tempDocument.getExportDate() == null );
					
							for (int i =0 ; i < limitHospitals ; i++)
							{
								if (tempDocument.getHospital().equals(listOfHospitals[i]))
									listOfHospitals[i].addDocuments(tempDocument);												
							}							
							if (tempDocument.getImportDate().compareTo(tempDocument.getExportDate()) >= 0 ) System.out.println ("The import date must be before the export date! Try Again!");
						} while (tempDocument.getImportDate().compareTo(tempDocument.getExportDate()) >= 0 );
					} 
					else System.out.println ("Error! There are not enough registrations in that hospital(doctor,patients,examinations). Enter them from the main menu!") ;		
				}
				else System.out.println ("Error! You must enter a hospital first! To do so , enter 1.") ;				
				break ;
			case (6): // Διαγραφή ασθενούς με βάση τον ΑΜΚΑ
				if ((listOfHospitals[0] != null) && (listOfHospitals[0].getListOfPatients()[0] !=null) && ((listOfHospitals[0].getListOfDocuments()[0] !=null))) // Πρέπει να υπάρχει τουλάχιστον ένα νοσοκομείο και ενας ασθενής σε αυτό 
				{
					do
					{
						search_amka = Reader.readString("Enter the patient's AMKA : ") ; 
						if (search_amka == null )		
							System.out.println("Error.Try again.");				
					} while (search_amka == null);				
					
					for (int q=0 ; (q < limitHospitals) && (listOfHospitals[q] != null) ; q++ )						 
					{	
						found = false ; 
						for (int i=0 ; (i < listOfHospitals[q].getNumOfPatients()) | (listOfHospitals[q].getListOfPatients()[i] != null) ; i++ ) 
						{
							if (listOfHospitals[q].getListOfPatients()[i].getAmka().equals(search_amka))
							{	
								tempPatient = listOfHospitals[q].getListOfPatients()[i] ;
								listOfHospitals[q].deletePatient(listOfHospitals[q].getListOfPatients()[i]);
								System.out.println("The patient was deleted successfully!");
								found = true ; 
							}							
						}
						
						if (found == true) // Αν βρέθηκε ασθενής
						{	
							for (int i=0 ; (i < listOfHospitals[q].getNumOfDocuments()) | (listOfHospitals[q].getListOfDocuments()[i] != null ) ; i++ ) 
							{
								if (listOfHospitals[q].getListOfDocuments()[i].getPatient().equals(tempPatient))
								{
									listOfHospitals[q].deleteDocument(listOfHospitals[q].getListOfDocuments()[i]);
									System.out.println("The patient's folder was deleted successfully!");									
								}								
							}						
						}	
						else System.out.println("There is no patient with that amka.Try again!");
						
					}
				}	
				else System.out.println("You must enter at least one hospital and at least one patient registered in it!");
				break ;
			case (7): //Εύρεση φακέλων νοσηλείας και εκτύπωση των στοιχείων τους με βάση:
				if ((listOfHospitals[0] != null) && (listOfHospitals[0].getListOfDocuments()[0] !=null)) // Αν υπάρχει τουλάχιστον ένα νοσοκομείο και εγγραφο
				{	
						j = 0;					
						do
						{
							search_amka = Reader.readString("Enter the patient's AMKA : ") ; 
							if (search_amka == null )		
								System.out.println("Error.Try again.");				
						} while (search_amka == null);	
						
						do  // Εισαγωγή νοσοκομείου
						{
							for (int i=0 ; (i < limitHospitals) && (listOfHospitals[i] != null) ; i++ )	
							{					
								if (listOfHospitals[i].getName().equals(Reader.readString("Enter the hospital's name :")))
									tempHospital =  listOfHospitals[i] ;
								else if (tempHospital == null) System.out.println("There is no hospital with that name.\nTry again");
							}					
							
						} while (tempHospital == null) ; 					
						
						do // Ημερομηνία εισαγωγής 				
						{
							search_in_date = Reader.readDate("Enter the date that the patient was imported : ") ;
							if (search_in_date == null )		
								System.out.println("Error.Try again.");				
						} while (search_in_date == null );
						
						do // Ημερομηνία εισαγωγής 				
						{
							search_out_date = Reader.readDate("Enter the date that the patient was exported : ") ;
							if (search_out_date == null )		
								System.out.println("Error.Try again.");				
						} while (search_out_date == null );
						
						for (int i =0 ; i < tempHospital.getNumOfDocuments() ; i++) // Εκτύπωση των στοιχείων των φακέλων
							correct_input = tempHospital.getListOfDocuments()[i].printPatientDocument(search_amka, search_in_date, search_out_date);
						
						if (!correct_input) System.out.println ("Check if the amka is correct or the dates are valid.Try again!\n");//Έλεγχος σε περίπτωση εισαγωγής Amka που δεν υπάρχει 
						// ή ημερομηνιών όπου η ημ.εισαγωγης είναι μετά την εξαγωγής κτλ.
												
				}
				else System.out.println ("Error! You must enter a hospital first with at least one patient folder! To do so , enter 1 or 5.") ;	
				break ;
			case (8): // Εκτύπωση των στοιχείων όλων των εξετάσεων, ή των ιατρών, ή των ασθενών, ή των φακέλων.
				if (listOfHospitals[0] != null) // Υπομενού
				{
					System.out.println ("\n1.Print examinations data.");
					System.out.println ("2.Print doctor data.");
					System.out.println ("3.Print patient data.");
					System.out.println ("4.Print patient documents data.\n");	
					
					do
					{
					   choice = Reader.readPositiveInt("Input the respective number of the option you want OR choose another one to change option : ") ;
					   if (choice == StandardInputRead.POS_ERROR ) 			
						   System.out.println("Error.Try again.");				
					} while (choice == StandardInputRead.POS_ERROR);
					
					switch (choice)
					{
					case (1): // Εκτύπωση εξετάσεων	
						j= 0 ;
						while ((listOfHospitals[j] != null) && (j < limitHospitals))
						{
							System.out.println ("\nThe " + listOfHospitals[j].getName()  + " hospital offers the following examinations to its patients : ");						
							for (int i = 0 ; (i  < listOfHospitals[j].getNumOfExams()) && (listOfHospitals[j].getListOfExams()[i] != null) ; i++)					
								System.out.println (listOfHospitals[j].getListOfExams()[i].getName());
							if (j == 1) break;
							else j++;
						}
						break;
					case (2): // Εκτύπωση γιατρών
						j =0 ;
						while ((listOfHospitals[j] != null) && (j < limitHospitals))
						{
							if (listOfHospitals[j] !=null)
							{
								System.out.println ("\nThe " + listOfHospitals[j].getName()  + " hospital has the following doctors with their respective specialties:");						
								for (int i = 0 ; (i  < listOfHospitals[j].getNumOfDoctors()) && (listOfHospitals[j].getListOfDoctors()[i] != null)  ; i++)
								{
									System.out.println ("Code	Name	Specialty");
									System.out.println (listOfHospitals[j].getListOfDoctors()[i].getPersonal_code() +"	"+ listOfHospitals[j].getListOfDoctors()[i].getName() +"	" + listOfHospitals[j].getListOfDoctors()[i].getSpecialty());
								}
							}
							if (j == 1) break;
							else j++;
						}					
						break;
					case (3): // Εκτύπωση ασθενών
						j =0 ;
						while ((listOfHospitals[j] != null) && (j < limitHospitals))							
						{							
							System.out.println ("\nThe " + listOfHospitals[j].getName()  + " hospital has the following patients with their respective AMKAs:");	
							
							for (int i = 0 ; (i  < listOfHospitals[j].getNumOfPatients()) && (listOfHospitals[j].getListOfPatients()[i] != null) ; i++)
							{
								System.out.println ("Amka	Name");
								System.out.println (listOfHospitals[j].getListOfPatients()[i].getName() +"	"+ listOfHospitals[j].getListOfPatients()[i].getAmka());
							}
							if (j == 1) break;
							else j++;
						}							
						break;
					case (4): // Εκτύπωση φακέλων
						j =0 ;
						while ((listOfHospitals[j] != null) && (j < limitHospitals))
						{
							System.out.println ("\nThe '" + listOfHospitals[j].getName()  + "' hospital has the following patient folders.");						
							for (int i = 0 ; (i  < listOfHospitals[j].getNumOfDocuments()) && (listOfHospitals[j].getListOfDocuments()[i] != null) ; i++)
							{
								System.out.println ("Patient : "+ listOfHospitals[j].getListOfDocuments()[i].getPatient().getName());
								System.out.println ("Doctor : "+ listOfHospitals[j].getListOfDocuments()[i].getDoctor().getName());
								System.out.println ("Import Date : "+ listOfHospitals[j].getListOfDocuments()[i].getImportDate());
								System.out.println ("Export Date :"+ listOfHospitals[j].getListOfDocuments()[i].getExportDate());
								System.out.println ("\nExaminations		Date");
								for (int w = 0 ; w < listOfHospitals[j].getListOfDocuments()[i].getNum_of_exams() ; w++)								
									System.out.println (listOfHospitals[j].getListOfDocuments()[i].getListOfExams()[w].getName()+"	 "+listOfHospitals[j].getListOfDocuments()[i].getListOfDates()[w]);								
							}
							if (j == 1) break;
							else j++;
						}					
						break;
					default :
						break;						
					}					
				}
				else System.out.println ("Error! You must enter a hospital first! To do so , enter 1.") ;
				break ;
			default :		
				System.out.println ("You have exited the software!");
				return;			
			}			
						
			
			
		}
		
		
	}
}
		
		

