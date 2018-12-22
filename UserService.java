import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    public static boolean flagSignUp= false;
    public static boolean flagLogIn= false;
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
                flagSignUp=true;
                break;
            }
        }
        if (!email.contains("@")|| password.length()<6)
        {
            if (!email.contains("@"))
                System.out.println("Invalid E-mail!");
            if (password.length()<6)
                System.out.println("Password is less than 6, It's too weak!");
            flagSignUp=true;
        }
        else {
            if (dublicate == false) {
                userDataBase newUser = new userDataBase();
                newUser.insert(email, name, password, number);
            }
        }
    }

    public void logIn()
    {
        userDataBase x= new userDataBase();
        List<User> allUsers = new ArrayList<User>();
        allUsers=x.getDataBase();
        Scanner sc=new Scanner(System.in);
        String email,password;
        System.out.println("Enter e-mail: ");
        email=sc.nextLine();
        System.out.println("Enter Password: ");
        password=sc.nextLine();
        boolean found=false;
        for (int i=0; i<allUsers.size();i++)
        {
            if (email.equals(allUsers.get(i).getEmail()) && password.equals(allUsers.get(i).getPassWord()))
            {
                found=true;
                break;
            }
        }
        if (found==true)
        {
            System.out.println("Logged in successfuly");
        }
        else
        {
            System.out.println("E-mail or password is wrong");
            flagLogIn=true;
        }
    }
}
 public void logIn()
    {
        userDataBase x= new userDataBase();
        List<User> allUsers = new ArrayList<User>();
        allUsers=x.getDataBase();
        Scanner sc=new Scanner(System.in);
        String email,password;
        System.out.println("Enter e-mail: ");
        email=sc.nextLine();
        System.out.println("Enter Password: ");
        password=sc.nextLine();
        boolean found=false;
        for (int i=0; i<allUsers.size();i++)
        {
            if (email.equals(allUsers.get(i).getEmail()) && password.equals(allUsers.get(i).getPassWord()))
            {
                found=true;
                break;
            }
        }
        if (found==true)
        {
            System.out.println("Logged in successfuly");
        }
        else
        {
            System.out.println("E-mail or password is wrong");
        }
    }