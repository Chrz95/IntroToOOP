// Χρήστος Ζαχαριουδάκης , 2014030056

public class Examination {

	private String exam_name ;	
	private int exam_code ;
	private static int numOfExams = 0 ; 
		
	Examination ()
	{	}	
	
	Examination (String name)
	{
		exam_name = name; 
		exam_code = numOfExams++ ; 		
	}	
	
	public String getName() {
		return exam_name;
	}
	public void setName(String name) 
	{
		this.exam_name = name;
	}

	public int getExam_code() {
		return exam_code;
	}

	
	
	
	
}
