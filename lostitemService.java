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


    public void SearchItem()
    {
        lostitemDatabase ob = new lostitemDatabase();
        allitems = ob.getDataBase();
        lostitem object = new lostitem();
        System.out.println("Enter the Category");
        String cat = input.nextLine();
        boolean f = false;
        boolean b = false;
        for(int i=0 ; i<allitems.size() ; i++)
        {
            if (cat.equals(allitems.get(i).getCategory()))
            {
                System.out.println("found");
                f=true;
                break;
            }
        }
        if (f==false)
        {
            System.out.println("not found");
        }
        if (f==true)
        {
            System.out.println("Enter the Description..");
            String des = input.nextLine();
            for (int i=0 ; i<allitems.size() ; i++)
            {
                if (des.equals(allitems.get(i).getDescription()))
                {
                    System.out.println("found");
                    b=true;
                    System.out.println(allitems.get(i).getDescription()+" , "+allitems.get(i).getCategory());
                    break;
                }

            }
            if (b==false)
            {
                System.out.println("not found");
            }
        }

    }
}
