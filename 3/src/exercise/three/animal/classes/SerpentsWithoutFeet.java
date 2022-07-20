// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

public class SerpentsWithoutFeet extends Serpent {
	
		int maxSpeed ; 
			
		public SerpentsWithoutFeet ()
		{		
			super();
			maxSpeed = 0 ; 
		}
		
		
		public SerpentsWithoutFeet (String name,String SerialRegistrationNumber)
		{		
			super(name,SerialRegistrationNumber);
		}	
		
		public int getMaxSpeed() {
			return maxSpeed;
		}
		public void setMaxSpeed(int maxSpeed) {
			this.maxSpeed = maxSpeed;
		}
		
		
		public String toPrint() 
		{		
			return (super.toPrint() + "\nIt does not have feet.\n" + "Max Speed : " + maxSpeed);
		}			
		
	}

	
	