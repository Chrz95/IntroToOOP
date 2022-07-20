// Χρήστος Ζαχαριουδάκης ,2014030056

import tuc.ece.cs102.util.*;
import exercise.three.list.classes.*  ;
import exercise.three.employee.classes.* ;
import exercise.three.animal.classes.* ;

public class MyMain {	
	
	static int int_check (String message)
	{		
		StandardInputRead Reader = new StandardInputRead ();
		int choice ; 
		
		do
		{
		   choice = Reader.readPositiveInt(message) ;
			if (choice == StandardInputRead.POS_ERROR )			
				System.out.println("Error.Input a positive integer!");			
		} while (choice == StandardInputRead.POS_ERROR);		
		return choice ; 
	}
	
	public static void main(String[] args) 
	{		
		int choice ,check_int ;
		StandardInputRead Reader = new StandardInputRead ();
		Zoo currentZoo  ; 
		AnimalItem temp_animalItem ;
		EmployeeItem temp_employeeItem ;
		Animal temp_animal ;		
		Employee temp_employee ; 
		node temp_node  ;		
					
		System.out.println ("Welcome!");
		currentZoo = new Zoo (Reader.readString("Enter the name of the zoo : "),Reader.readString("Enter the name of the city that the zoo is located : "));
				
		while (true)
		{			
			System.out.println ("\n1.Input an employee.");
			System.out.println ("2.Input an animal.");
			System.out.println ("3.Delete an animal.");			
			System.out.println ("4.Search an employee.");
			System.out.println ("5.Search an animal.");
			System.out.println ("6.Print all of the registrations.");
			System.out.println ("7.Print specific categories.");
			System.out.println ("8.Exit the software.");
			
			choice = int_check ("\nInput the respective number of the option you want: ") ;
									
			switch (choice)
			{
				case (1): // Εισαγωγή υπαλλήλου (employee)
					System.out.println ("\n1.Input an assistant.");
					System.out.println ("2.Input a trainer.");					
					choice = int_check ("\nInput the respective number of the option you want: ") ;
					
					switch (choice)
					{
						case (1):  // Εισαγωγή βοηθού (Assistant)
							temp_employee = new Assistant (Reader.readString("Enter the assistant's name  : "),Reader.readString("Enter the AFM : "));
							((Assistant)temp_employee).setDepartment() ; 
							temp_employeeItem = new EmployeeItem (temp_employee) ;
							
							if (currentZoo.getListOfEmployees().search(temp_employeeItem) == null) // Αν δεν υπάρχει ξανά ο ίδιος ΑΦΜ
									currentZoo.getListOfEmployees().insert(temp_employeeItem);	
							else System.out.println ("An employee with '" + temp_employee.getAFM() + "' AFM already exists. Please enter another one!");							
							break;
						case (2) : // Εισαγωγή εκπαιδευτή (Trainer)
							temp_employee = new Trainer (Reader.readString("Enter the trainer's name : "),Reader.readString("Enter the AFM : "));
							((Trainer)temp_employee).setTraining();
							temp_employeeItem = new EmployeeItem (temp_employee) ;
							
							if (currentZoo.getListOfEmployees().search(temp_employeeItem) == null) // Αν δεν υπάρχει ξανά ο ίδιος ΑΦΜ
								currentZoo.getListOfEmployees().insert(temp_employeeItem);	
							else System.out.println ("An employee with '" + temp_employee.getAFM() + "' AFM already exists. Please enter another one!");							
							break;
						default :
							System.out.println ("Wrong choice.Please input a number corresponding the menu choices! Enter 1 to open the employee input menu.");
							break ;
					}					
					break;					
				case (2):
					System.out.println ("\n1.Input a serpent.");
					System.out.println ("2.Input a bird.");
					System.out.println ("3.Input a fish.");
				
					choice = int_check ("\nInput the respective number of the option you want: ") ;
				
					switch (choice)
					{
						case (1):	 // Εισαγωγή ερπετού (Serpent)						
							
							System.out.println ("\n1.Input a serpent with feet.");
							System.out.println ("2.Input a serpent without feet.");							
					
							choice = int_check ("\nInput the respective number of the option you want: ") ;
							
							switch (choice)
							{
								case (1) :	// Εισαγωγή ερπετού με πόδια (SerpentsWithFeet)	
									temp_animal = new SerpentsWithFeet (Reader.readString("\nEnter the name of the animal : "),Reader.readString("Enter the registration number of the animal : "));
									((SerpentsWithFeet)temp_animal).setSkin_covering() ; 
									do
									{
										check_int = int_check ("Number of feet : ") ;
										if ((check_int<2) | (check_int>10)) System.out.println ("Please enter more than one foot and less than ten!");			
									}	
									while ((check_int<2) | (check_int>10));
									((SerpentsWithFeet)temp_animal).setNumberOfFeet(check_int); 
									temp_animalItem = new AnimalItem (temp_animal) ;									
									if (currentZoo.getListOfAnimals().search(temp_animalItem) == null) // Αν δεν υπάρχει ξανά το ίδιο ζώο
										currentZoo.getListOfAnimals().insert(temp_animalItem);	
									else System.out.println ("An animal with '" + temp_animal.getSerialRegistrationNumber() + "' registration code already exists. Please enter another one!");									
									break;
								case (2) :  // Εισαγωγή ερπετού χωρις πόδια (SerpentsWithoutFeet)
									temp_animal = new SerpentsWithoutFeet (Reader.readString("Enter the name of the animal : "),Reader.readString("Enter the registration number of the animal : "));
									((SerpentsWithoutFeet)temp_animal).setSkin_covering() ; 
									do
									{
										check_int = int_check ("Max Speed : ") ;
										if ((check_int<=0) | (check_int > 150)) System.out.println ("The maximum speed cannot be zero , less than zero or more than 150. Please enter a valid speed!");			
									}	
									while ((check_int<=0) | (check_int > 150));
									((SerpentsWithoutFeet)temp_animal).setMaxSpeed(check_int); 										
									temp_animalItem = new AnimalItem (temp_animal) ;
									if (currentZoo.getListOfAnimals().search(temp_animalItem) == null) // Αν δεν υπάρχει ξανά το ίδιο ζώο
										currentZoo.getListOfAnimals().insert(temp_animalItem);	
									else System.out.println ("An animal with '" + temp_animal.getSerialRegistrationNumber() + "' registration code already exists. Please enter another one!");	
									break;
								default :
									System.out.println ("Wrong choice.Please input a number corresponding the menu choices! Enter 2 to open the animal input menu.");
									break ;
							}							
							break;
						case (2) : // Εισαγωγή πουλιού (Bird)	
							temp_animal = new Bird (Reader.readString("Enter the name of the animal : "),Reader.readString("Enter the registration number of the animal : "),Reader.readString("Enter the feather color : "));
							temp_animalItem = new AnimalItem (temp_animal) ;
							if (currentZoo.getListOfAnimals().search(temp_animalItem) == null) // Αν δεν υπάρχει ξανά το ίδιο ζώο
								currentZoo.getListOfAnimals().insert(temp_animalItem);	
							else System.out.println ("An animal with '" + temp_animal.getSerialRegistrationNumber() + "' registration code already exists. Please enter another one!");							
							break; 
						case (3) : // Εισαγωγή ψαριού (Fish)	
							temp_animal = new Fish (Reader.readString("Enter the name of the animal : "),Reader.readString("Enter the registration number of the animal : "),Reader.readString("Enter the shape : "),Reader.readString("Enter the color : "));
							temp_animalItem = new AnimalItem (temp_animal) ;
							if (currentZoo.getListOfAnimals().search(temp_animalItem) == null) // Αν δεν υπάρχει ξανά το ίδιο ζώο
								currentZoo.getListOfAnimals().insert(temp_animalItem);	
							else System.out.println ("An animal with '" + temp_animal.getSerialRegistrationNumber() + "' registration code already exists. Please enter another one!");
							break;
						default :
							System.out.println ("Wrong choice.Please input a number corresponding the menu choices! Enter 2 to open the animal input menu.");
							break ;
					}								
					break;
				case (3): // Delete an animal using registration code (delete function of list class)
					if (!currentZoo.getListOfAnimals().isEmpty())
					{		
						temp_animal = new Animal (Reader.readString("Enter the registration code of the animal you wish to erase : "));
						temp_animalItem = new AnimalItem (temp_animal);
						if ((currentZoo.getListOfAnimals().delete(temp_animalItem) == null) && (!currentZoo.getListOfAnimals().isEmpty()))
							System.out.println("There is no animal registered with '" + temp_animal.getSerialRegistrationNumber()  + "' registration code") ; // Έλεγχος σε περίπτωση που δεν υπάρχει το ζώο
						else System.out.println("An animal with '" + temp_animal.getSerialRegistrationNumber()  + "' registration code is erased successfully!");
					}
					else System.out.println ("There are no animals registered!");
					break;				
				case (4): // Search an employee using AFM (search function of list class)
					if (!currentZoo.getListOfEmployees().isEmpty())
					{
						temp_employee = new Employee (Reader.readString("Enter the AFM of the employee you wish to find : "));
						temp_employeeItem = new EmployeeItem (temp_employee);
						temp_node = currentZoo.getListOfEmployees().search(temp_employeeItem);
						if (temp_node == null) System.out.println("There is no employee registered with '" + temp_employee.getAFM()  + "' AFM") ; // Έλεγχος σε περίπτωση που δεν υπάρχει ο υπάλληλος
						else System.out.println(temp_node.getValue().toString()) ;
					}
					else System.out.println ("There are no employees registered!");
					break;
				case (5): // Search an animal using registration code (search function of list class)
					if (!currentZoo.getListOfAnimals().isEmpty())
					{
						temp_animal = new Animal (Reader.readString("Enter the registration code of the animal you wish to find : "));
						temp_animalItem = new AnimalItem (temp_animal);
						temp_node = currentZoo.getListOfAnimals().search(temp_animalItem);
						if (temp_node == null) System.out.println("There is no animal registered with '" + temp_animal.getSerialRegistrationNumber()  + "' registration code") ;  // Έλεγχος σε περίπτωση που δεν υπάρχει το ζώο
						else System.out.println(temp_node.getValue().toString()) ;						
					}
					else System.out.println ("There are no animals registered!");
					break;
				case (6): // Εκτύπωση όλων των στοιχείων
					if ( (!currentZoo.getListOfAnimals().isEmpty()) && (!currentZoo.getListOfEmployees().isEmpty()) )
					{					
						System.out.println ("\nThe name of the zoo is : " + currentZoo.getName());
						System.out.println ("The zoo is located at : " + currentZoo.getCity() );						
						System.out.println ("\nIt has " + currentZoo.getListOfEmployees().getLength() + " employees : \n" );						
						System.out.println ("Assistants : " );
						currentZoo.getListOfEmployees().printAllInHierarchy("exercise.three.employee.classes.Assistant"); 
						System.out.println ("\nTrainers : " );
						currentZoo.getListOfEmployees().printAllInHierarchy("exercise.three.employee.classes.Trainer");		
						System.out.println ("\nIt has " + currentZoo.getListOfAnimals().getLength() + " animals : \n" );					
						System.out.println ("Serpents with feet : " );
						currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithFeet");
						System.out.println ("\nSerpents without feet : " );
						currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithoutFeet");
						System.out.println ("\nBirds : " );
						currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.Bird");
						System.out.println ("\nFish : " );
						currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.Fish");
					}
					else System.out.println ("One of lists or both of them are empty! Enter both employees and animals.");
					break;
				case (7): // Εκτύπωση όλων των στοιχείων συγκεκριμένων κατηγοριών
					System.out.println ("\n1.Print employees");
					System.out.println ("2.Print animals");
					
					choice = int_check ("\nInput the respective number of the option you want : ") ;
					
					switch (choice)
					{
						case (1): // Εκτύπωση υπαλλήλων
							if  (!currentZoo.getListOfEmployees().isEmpty())
							{
								System.out.println ("There are the following categories of employees :\n");
								System.out.println ("1.Assistants");
								System.out.println ("2.Trainers");
								
								choice = int_check ("\nInput the respective number of the option you want: ") ;
								
								switch (choice) 
								{
									case 1: // Print all assistants
										System.out.println ("\nAssistants :");
										currentZoo.getListOfEmployees().printAllInHierarchy("exercise.three.employee.classes.Assistant");
										break;
									case 2: // Print all trainers
										System.out.println ("\nTrainers :");
										currentZoo.getListOfEmployees().printAllInHierarchy("exercise.three.employee.classes.Trainer");
										break;
									default:
										System.out.println ("Wrong choice.Please input a number corresponding the menu choices!. Enter 7 to print a category of animals or employees.");
										break ;	
								}
							}
							else System.out.println ("There are no employees registered! Try again!");
							break;
						case (2): // Εκτύπωση ζώων
							if  (!currentZoo.getListOfAnimals().isEmpty())
							{
								System.out.println ("There are the following categories of animals :\n");
								System.out.println ("1.Serpents");
								System.out.println ("2.Fish");
								System.out.println ("3.Birds");
							
								choice = int_check ("\nInput the respective number of the option you want: ") ;
							
								switch (choice) 
								{
									case 1: // Print all serpents (and their sub-categories)
										System.out.println ("There are the following categories of serpents :\n");
										System.out.println ("1.All categories");
										System.out.println ("2.Serpents with feet");
										System.out.println ("3.Serpents without feet");
										choice = int_check ("\nInput the respective number of the option you want: ") ;
										
										switch (choice) 
										{
											case 1: // Print all serpents (and their sub-categories)
												System.out.println ("\nSerpents with feet :");
												currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithFeet");
												System.out.println ("\nSerpents without feet : ");
												currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithoutFeet");
												break;
											case 2: // Print all serpents with feet
												System.out.println ("\nSerpents with feet :");
												currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithFeet");
												break;
											case 3: // Print all serpents without feet
												System.out.println ("\nSerpents without feet :");
												currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.SerpentsWithoutFeet");
												break;	
											default:
												System.out.println ("Wrong choice.Please input a number corresponding the menu choices!. Enter 7 to print a category of animals or employees.");
												break ;	
										}										
										break;
									case 2: // Print all fish
										System.out.println ("\nFish :");
										currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.Fish");
										break;
									case 3: // Print all birds
										System.out.println ("\nBirds :");
										currentZoo.getListOfAnimals().printAllInHierarchy("exercise.three.animal.classes.Bird");
										break;	
									default:
										System.out.println ("Wrong choice.Please input a number corresponding the menu choices!");
										break ;	
								}
							}
							else System.out.println ("There are no animals registered! Try again!");
						break;
						default :
							System.out.println ("Wrong choice.Please input a number corresponding the menu choices!. Enter 7 to print a category of animals or employees.");
							break ;	
					}
					break;
				case (8):
					System.out.println ("You have exited the software!");
					return ;					
				default :
					System.out.println ("Wrong choice.Please input a number corresponding the menu choices!");
					break ;

			}			
			
		}
		
		
	}
		
		
	}


