// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

public class SerpentsWithFeet extends Serpent {

		private int numberOfFeet ;
			
		public SerpentsWithFeet ()
		{		
			super();
			numberOfFeet = 0 ; 
		}
		
		public SerpentsWithFeet (String name,String SerialRegistrationNumber)
		{		
			super(name,SerialRegistrationNumber);
			
		}
		
		public int getNumberOfFeet() {
			return numberOfFeet;
		}
		public void setNumberOfFeet(int numberOfFeet) {
			this.numberOfFeet = numberOfFeet;
		}
		
		
		public String toPrint() 
		{		
			return (super.toPrint() + "\nIt has "  + numberOfFeet + " feet.");
		}		
		
		
	}

	
	
	
	
	
	
	
	

