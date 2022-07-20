// Χρήστος Ζαχαριουδάκης ,2014030056

package exercise.three.animal.classes;

public class Fish extends Animal {

	private String shape , skin_color ; 
	
	public Fish (String name,String SerialRegistrationNumber,String shape,String skin_color)
	{		
		super(name,SerialRegistrationNumber);
		this.shape = shape ;
		this.skin_color = skin_color ;
	}

	public String getShape() 
	{
		return shape;
	}

	public String getSkin_color() 
	{
		return skin_color;
	}
	
	public String toPrint() 
	{		
		return (super.toPrint() + "\nIt is a fish.\n" + "Shape : " + shape + "\nSkin Color : " + skin_color);
	}		
		
}
