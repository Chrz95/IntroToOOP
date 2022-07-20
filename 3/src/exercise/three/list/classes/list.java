package exercise.three.list.classes;



public class list {
	  protected node head;              // ������� ��� ����� ��������
	  protected int length;                // ������� ��������� ��� �����

	  public list()  
	  {  
		  head = null;  
		  length = 0;    // �� default ����� ����
	  }
  
	  public boolean isEmpty()    
	  { 
		  return head == null; 
	  }
  
	  public node insert(Item a) 
	  {      
	      length++;
	      head = new node(a, head);
	      return head;
  	  }
	  
	  public int getLength() { return length; }
		public void clearList() { head = null; length = 0; }

		public void print() 
		{
		   for (node tmp = head;      tmp != null;      tmp = tmp.getNext())
		      // ���� ����� ���������� ��� toString() ��� ��� Object ��� ������ ��
	           // ��� ������ ���� ��� �� ��������� ��� �� ��������� ���� println
		      System.out.println("node with data: " +  tmp.getValue());
		}
		public node search(Item a) {
		    for (node tmp = head;     tmp != null;      tmp = tmp.getNext())
	             if (a.equals(tmp.getValue()))    // ��� ���������� � equals ��� Item
		            return tmp;                           // ���� ������������� �� ������ �
	         return null;                                   //  equals ��� ���������� ���������
	  	}

		 public node delete (Item a) {
			 node n1 = head, n2 = head;
			 int found = 0 ;

			    while ((n1 != null) && (!a.equals( n1.getValue() ) ) ) {  
			        // �������� ��� ����� ��� ����� �� ����������� ��� ��� ����������� ���
			        n2 = n1; n1 = n1.getNext(); }
			    if (n1 != null) { // ������� � ������ ��� ��������. �� ����������� ��� n1
			    	found = 1 ; 
			        length--;
			        if (n2 != n1)       // n1 != head
			            n2.setNext(n1.getNext());
			        else                  // ����������� �� ����� ��������. ������� �� head
			            head = head.getNext();     
			        n1.setNext(null);
			    }
			    if (found == 1)  return head;
			    else return null ; 
			  }
		 
		 public Item removeFirst() {
			    node tmp = head; // �� ������������� �� head, ��� ������� ��� tmp 
			                                 //  ��� ����� �����
			    if (head != null) {   // ������� ����� ��������;;;
			      length--;
			      head = head.getNext(); // ���������� ��� ������� ��������
			      tmp.setNext(null);          // ������� ���� ����������� ������
			      return tmp.getValue();
			    }
			    else
			      return null;
			}


	  
}
