import java.util.*;

public class lostitemService {
	Scanner input = new Scanner (System.in);
	List<lostitem> allitems = new ArrayList<lostitem>();

	public void PostItem()
	{
		lostitem ob=new lostitem();
		System.out.println("Enter Your Description");
		String x = input.nextLine();
		
		System.out.println("Enter the Category");
		String y = input.nextLine();
		
		ob.setDescription(x);
		ob.setCategory(y);
		
		lostitemDatabase ob2 = new lostitemDatabase();
		ob2.addLostitem(ob.getDescription(), ob.getCategory());
	}
	
	
}
