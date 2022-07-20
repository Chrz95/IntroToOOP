// Χρήστος Ζαχαριουδάκης  , 2014030056

#include <stdio.h>
#include <stdlib.h>

struct list 
{
	int value;
	struct list * next ; 	
};

void freeList(struct list *);
void insertNodeList(int, struct list **);
struct list * multiply_check (struct list *);

void main(void)
{

int i=0,value=0,stoixeia=0,scan_check;
char choice;
struct list *head = NULL, *result = NULL;

printf ("|--------------------------------------------------------------------|\n");
printf ("| Welcome! This software will allow you enter a number of integers   |\n| and check if every value of the list generated is less than the    |\n|  next 2 multiplied .");
printf ("                                               |\n");
printf ("|--------------------------------------------------------------------|\n");

do  // Επανάληψη του προγράμματος σε περίπτωση που το ζητήσει ο χρήστης 
{
   printf ("\n***************************************************\n");	
   printf ("How many integers do you wish to enter (minimum 0)?\n");
   do // Έλεγχος για εγκυρότητα αριθμού στοιχείων (>0)
   {
      do // Έλεγχος εισόδου της scanf
	  {		 
   	     scan_check = scanf("%d",&stoixeia);
	     fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός integer ή παραπάνω απο 1 integer  	        	
	     if (!scan_check) printf ("Wrong input. Try again : \n");	  
	  } while (!scan_check);
	  
      if (stoixeia >= 0)
      {	      
         if (stoixeia != 0) printf ("Input %d integers , seperated by Enter button :\n",stoixeia);
         head = NULL ; // Αρχικοποιήση του head για την περίπτωση επανάληψης της διαδικασίας
	     for(i=0;i<stoixeia;i++) // Εισαγωγή δεδομένων στον πίνακα
         {         	
         	do // Έλεγχος εισόδου της scanf
	        {		 
   	           scan_check = scanf ("%d",&value);
	           fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός integer ή παραπάνω απο 1 integer  	        	
	           if (!scan_check) printf ("Wrong input. Try again : \n");	  
	        } while (!scan_check);
	        insertNodeList(value,&head);	
         }
       }      
      else printf ("Please input a positive number.(>=0)\n");
   } while (stoixeia<0);

   result =  multiply_check (head);

   if ((result == NULL) && (stoixeia>2) ) printf ("Every value is indeed less than the next two mulltiplied.\n") ;   
   else if ((result == NULL) && (stoixeia<=2)) printf ("Only %d integers were entered , thus the list is considered valid.\n",stoixeia);
   else if (result !=NULL) printf ("The value %d is greater than %d*%d =  %d.\n",result->value,result->next->value,result->next->next->value,result->next->value * result->next->next->value);   
   freeList(head);
   printf ("\nDo you wish to repeat the process (Y/N)?\n");

    do // Ελεγχος αν εισάχθηκε Y ή Ν
    {
	    do // Έλεγχος εισόδου της scanf
	    {		 
   	       scan_check = scanf("%c",&choice);
	       fflush(stdin); // Άδειασμα ροης εισόδου για την περίπτωση εισαγωγής δεδομένου εκτός integer ή παραπάνω απο 1 integer  	        	
	    } while (!scan_check);   	
   	    
   	    if ( (choice != 'Y') && (choice != 'N') ) 
   	       printf ("You did not input a valid answer.Try again:\n");   	
    } while ((choice != 'Y') && (choice != 'N'));
   
} while (choice == 'Y');

printf ("You have exited the software!\n");
system ("PAUSE");
return ; 
}

void insertNodeList(int v, struct list **l) 
{ 
	struct list *node;
	struct list *tmp = *l;
	
	node = (struct list *)malloc(sizeof(struct list));
	node->value = v;
	node->next = NULL;
		
    if(*l == NULL)
        *l = node;
    else     	
	{
		while(tmp->next != NULL)
			tmp = tmp->next;
		tmp->next = node;
    }          
}

void freeList(struct list *node)
{
	struct list *p;
	if(node == NULL)
	   return;	
	p = node;
	node = node->next;
	free(p);
	freeList(node);
}

struct list * multiply_check (struct list * node)
{	
	/* Περίπτωση που έχουμε περισσότερους δύο ή λιγότερους κόμβους */
   /*       0 κομβοι            1 κομβος                      2 κομβοι     */
   
   if ((node == NULL) || (node->next == NULL) || (node->next->next == NULL))  // Περίπτωση που έχουμε δύο η λιγότερους αριθμούς
   {
      printf ("\nThe list is valid.\n"); // Ικανοποιεί το κριτήριο
      return NULL;
   }

  /* Περίπτωση που έχουμε περισσότερους απο δύο κόμβους */

   if (node->next->next != NULL)  // Aν υπάρχει μεθεπόμενος κόμβος έλεγξς να ισχύει το κριτήριο
   {
      if (node->value < (node->next->value * node->next->next->value)) // Εαν ισχύει η συνθήκη για αυτόν τον κόμβο προχώτησε στον επόμενο
        return multiply_check (node->next);
      else // αλλίως η λίστα δεν είναι έγκυρη οπότε επέστρεψε δείκτη στον κόμβο αυτό
      {
         printf ("\nThe list is not valid since %d > %d * %d = %d.\n",node->value,node->next->value,node->next->next->value,node->next->value * node->next->next->value);	
         return node ; 
      }
   }
   else if (node->next->next == NULL)  // Αν δεν υπάρχει μεθεπόμενος κόμβος έχουμε δηλαδή φτάσει κοντά στο τέλος
   {
      printf ("\nThe list is valid.\n"); // Ικανοποιεί το κριτήριο
      return NULL;   	
   }
}


