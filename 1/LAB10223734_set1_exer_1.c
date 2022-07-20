// Χρήστος Ζαχαριουδάκης  , 2014030056

#include <stdio.h>
#include <stdlib.h>

int mirror_pair_check (int *,int,int);

int main(void)
{

int stoixeia=0,i=0,returned_value=0,scan_check ; 
int *array_of_integers = NULL;
char choice = 'N'; 

printf ("|--------------------------------------------------------------------|\n");
printf ("| Welcome! This software will allow you enter a number of integers   |\n| and determine if there is a mirror pair among them.");
printf ("                |\n");
printf ("|--------------------------------------------------------------------|\n");

do // Επανάληψη του προγράμματος σε περίπτωση που το ζητήσει ο χρήστης   
{
   printf ("\n***************************************************\n");	
   printf ("How many integers do you want to enter (minimum 1)?\n");
   do // Έλεγχος για εγκυρότητα αριθμού στοιχείων (>0)
   {
   	  do // Έλεγχος εισόδου της scanf
	  {		 
   	     scan_check = scanf("%d",&stoixeia);
	     fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός integer ή παραπάνω απο 1 integer  	        	
	     if (!scan_check) printf ("Wrong input. Try again : \n");	  
	  } while (!scan_check);
	  
      if (stoixeia > 0)
      {	
         array_of_integers = (int *) malloc (sizeof(int)*stoixeia)  ; 
         i = 0 ;   //Αρχικοποιήση του i σε περίπτωση επανεκτέλεσης του εξωτερικού loop
         printf ("Input %d integers , seperated by Enter button :\n",stoixeia);
	     do // Εισαγωγή δεδομένων στον πίνακα
         {   
		    do // Έλεγχος εισόδου της scanf
	        {		 
   	           scan_check = scanf ("%d",&array_of_integers[i++]); 	           	        	
	           if (!scan_check) printf ("Wrong input. Try again : \n");	  
	        } while (!scan_check);
		    fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός integer ή παραπάνω απο 1 integer   	
        } while (i < stoixeia);		
      }
      else printf ("You must input at least one integer.\n");
   } while (stoixeia < 1);

   returned_value = mirror_pair_check(array_of_integers,stoixeia-1,0);
   
   if (returned_value!= -1) 	//Εκτύπωση τιμής επιστροφής της συνάρτησης
      printf ("The first number of the mirror pair is placed at position %d of the array.\n",returned_value);
   else printf ("The function returned -1,thus no mirror pair was found.\n");  
	 	
   free (array_of_integers);
   
   printf ("\nDo you want to run the process again (Y/N)?\n");   
   do // Ελεγχος αν εισάχθηκε Y ή Ν
   {  	
      do // Έλεγχος εισόδου της scanf
	  {		 
   	     scan_check = scanf("%c",&choice);  
         fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός char η παραπάνω δεδομένων 	
	  } while (!scan_check); 
	  
   	  if ( (choice != 'Y') && (choice != 'N') ) 
	    printf ("You did not enter a valid answer. Try again :\n");   
			
   } while ((choice != 'Y') && (choice != 'N'));
   
} while (choice == 'Y');

printf ("You have exited the program !\n");
system ("PAUSE");
return;
}

int mirror_pair_check (int *a,int stoixeia,int i)
{
if (stoixeia<i) // Τέλος αναδρομής αν δεν βρεθεί ζεύγος
{
   printf ("\nThere is no mirror pair in the given integers.\n");
   return -1;   
}
if (a[0] == a[i] + a[stoixeia])	//Τέλος αναδρομής αν βρεθεί ζεύγος
{
   printf("\nThe mirror pair is (%d,%d) , since their sum is %d.\n",a[i],a[stoixeia],a[0]);
   return i;
}
return mirror_pair_check (a,--stoixeia,++i); // Εκ νέου κάλεσμα της συνάρτησης
}


