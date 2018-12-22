import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    UserService myUserService =new UserService();
    lostitemService myLostitemService= new lostitemService();

    while (true)

    {
        System.out.println("Enter 1 for sign up: ");
        System.out.println("Enter 2 for log in: ");
        System.out.println("Enter 3 for exit: ");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        if(choice==1)
        {
            myUserService.signUp();
            while (true)
            {
                if (myUserService.flagSignUp==true)
                {
                break;
                }
                System.out.println("Enter 1 for post lost item: ");
                System.out.println("Enter 2 for search for lost item: ");
                System.out.println("Enter 3 for exit: ");
                int secondChoice=input.nextInt();

                if (myUserService.flagSignUp==false) {
                if (secondChoice==1)
                {
                    myLostitemService.PostItem();
                }
                else if (secondChoice==2)
                {
                    myLostitemService.SearchItem();
                }
                else if(secondChoice==3)
                {
                    break;
                }
                else {
                    System.out.println("Your choice is invalid, please try again ");
                }
                }
            }
        }
        else if(choice==2)
        {
           myUserService.logIn();
           while (true)
           {
               if (myUserService.flagLogIn==true)
               {
                   break;
               }
               System.out.println("Enter 1 for post lost item: ");
               System.out.println("Enter 2 for search for lost item: ");
               System.out.println("Enter 3 for exit: ");
               int secondChoice=input.nextInt();

               if (myUserService.flagLogIn==false) {
               if (secondChoice==1)
               {
                   myLostitemService.PostItem();
               }
               else if (secondChoice==2)
               {
                   myLostitemService.SearchItem();
               }
               else if(secondChoice==3)
               {
                   break;
               }
               else {
                   System.out.println("Your choice is invalid, please try again ");
               }
               }
           }
        }

        else if(choice==3)
            break;
        else
            System.out.println("Your choice is invalid, please try again ");
    }

    }
}