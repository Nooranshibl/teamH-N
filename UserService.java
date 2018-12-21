import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserService {
    public void signUp()
    {
        userDataBase x= new userDataBase();
        List<User> allUsers = new ArrayList<User>();
        allUsers=x.getDataBase();
        Scanner sc=new Scanner(System.in);
        String email,name,password;
        int number;
        System.out.println("Enter e-mail: ");
        email=sc.nextLine();
        System.out.println("Enter Name: ");
        name=sc.nextLine();
        System.out.println("Enter Password: ");
        password=sc.nextLine();
        System.out.println("Enter phone number: ");
        number=sc.nextInt();
        boolean dublicate=false;
        for (int i=0; i<allUsers.size();i++)
        {
            if (email.equals(allUsers.get(i).getEmail()))
            {
                System.out.println("E-mail already used!");
                dublicate=true;
                break;
            }
        }
        if (!email.contains("@"))
        {
            System.out.println("Invalid E-mail");
        }
        else {
            if (dublicate == false) {
                userDataBase newUser = new userDataBase();
                newUser.insert(email, name, password, number);
            }
        }
    }

}
