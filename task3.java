package oasis_infobyte;

import java.util.*;

class Registration_Window{
    static void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Enter your name : ");
        task3.name=sc.nextLine();
        System.out.print("Enter username : ");
        task3.user=sc.nextLine();
        while(true){
            System.out.print("Enter password : ");
            task3.pass=sc.nextLine();
            System.out.print("ReEnter/Verify password : ");
            String repass=sc.nextLine();
            if(repass.equals(task3.pass)){
                System.out.println("Password matched...");
                break;
            }
            else{
                System.out.println("Password did't match.!!! Please try again...");
            }
        }
        System.out.print("Enter your Account number : ");
        task3.accnumber=sc.nextLine();
        System.out.println("\n" + "REGISTRATION SUCCESSFULLY...!");
        System.out.println("------------------------------------------------");
        task3.prompt();
    }
}

class Login_Window{
    static void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Enter your username : ");
        String loguser=sc.nextLine();
        System.out.print("Enter your password : ");
        String logpass=sc.nextLine();
        System.out.print("Enter your Account number : ");
        String logacn=sc.nextLine();
        if(loguser.equals(task3.user) && logpass.equals(task3.pass) && logacn.equals(task3.accnumber)){
            System.out.println("\n" + "LOGIN SUCCESSFULLY...!");
            System.out.println("------------------------------------------------");
        }
        else{
            System.out.println("\n" + "Incurrect details...! Please try again...");
            task3.homepage_login();
        }
    }
}

public class task3 {
    public static String name;
    public static String user;
    public static String pass;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
    public static int balance = 57000, withdraw, deposit, transfer;
    public static String receiver, acnum;

    public static void homepage_reg(){
        // System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("WELCOME TO THE ATM INTERFACE");
        System.out.println("REGISTRATION WINDOW");
        System.out.println("------------------------------------------------");
        System.out.println("Select Option :");
        System.out.println("Select 1 to Register...");
        System.out.println("Select 2 to Exit...");
        System.out.println("------------------------------------------------");
        System.out.print("Enter option: ");
        int choice =sc.nextInt();
        if (choice==1){
            Registration_Window.register();
        }
        else {
            if(choice==2){
                System.out.println("\n" + "Thank You for Transactions...");
                System.exit(0);
            }
            else{
                System.out.println("\n" + "Select a value only from the given options...!");
                homepage_reg();
            }
        }
    }

    public static void homepage_login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("WELCOME TO THE ATM INTERFACE");
        System.out.println("LOGIN WINDOW");
        System.out.println("------------------------------------------------");
        System.out.println("Select Option :");
        System.out.println("Select 1 to Login...");
        System.out.println("Select 2 to Exit...");
        System.out.println("------------------------------------------------");
        System.out.print("Enter option: ");
        int choice =sc.nextInt();
        if (choice==1){
            Login_Window.login();
        }
        else {
            if(choice==2){
                System.out.println("\n" + "Thank You for Transactions...");
                System.exit(0);
            }
            else{
                System.out.println("\n" + "Select a value only from the given options...!");
                homepage_login();
            }
        }
    }

    public static void transaction(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n" + "Transaction History ---> ");
        int k=0;
        if(task3.balance>0)
        {
            for(int i = 0; i<(task3.history.size()/2); i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(task3.history.get(k)+" ");
                    k++;
                }
                System.out.println("/-");
            }
            System.out.println();
        }
        else {
            System.out.println("Your account is empty.!!!");
            System.out.println();
        }
    }

    public static void withdraw_money(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter money to be withdrawn: ");
        withdraw = sc.nextInt();
        if (task3.balance >= withdraw)
        {
            task3.balance = task3.balance - withdraw;
            System.out.println("\n" + "Transaction Successful...!!!");
            task3.history.add("Withdrawn:  Rs.");
            task3.history.add(Integer.toString(withdraw));
            System.out.println("Amount Rs." + withdraw + "/- withdrawal successful!");
            System.out.println("Please collect your money...");
        }
        else
        {
            System.out.println("\n" + "Insufficient Balance!!!");
        }
        System.out.println();
    }

    public static void deposite_money(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter money to be deposite: ");
        deposit = sc.nextInt();
        task3.balance = task3.balance + deposit;
        task3.history.add("Deposited:  Rs.");
        task3.history.add(Integer.toString(deposit));
        System.out.println("\n" + "Amount Rs." + deposit + "/- deposit successful!");
        System.out.println("Your money has been successfully deposited.!");
        System.out.println();
    }

    public static void transfer_money(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter the username of the receiving body: ");
        receiver=sc.next();
        System.out.print("Enter the account number of the receiving body: ");
        acnum=sc.next();
        System.out.print("Enter the amount to be transferred: ");
        transfer=sc.nextInt();
        if(transfer<= task3.balance){
            task3.balance = task3.balance - transfer;
            System.out.println("\n" + "Transaction Successful...!!!");
            task3.history.add("Transferred:  Rs.");
            task3.history.add(Integer.toString(transfer));
            System.out.println("Amount Rs." + transfer + "/- transferred successfully...");
        }
        else{
            System.out.println("\n" + "Insufficient balance to transfer the cash...!!!");
        }
        System.out.println();
    }

    static void prompt(){
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("------------------------------------------------");
            System.out.println("Automatic Atm Machine ---> Welcome "+ task3.name+"!");
            System.out.println("------------------------------------------------");
            System.out.println("Select 1 for Transaction History...");
            System.out.println("Select 2 for Withdraw Money...");
            System.out.println("Select 3 for Diposit Money...");
            System.out.println("Select 4 for Check Balance...");
            System.out.println("Select 5 for Transfer Money...");
            System.out.println("Select 6 for Quit/Logout...");
            System.out.println("------------------------------------------------");
            System.out.print("Select the operation you want to perform: ");
            try
            {
                int n = sc.nextInt();
                switch(n)
                {
                    case 1:
                        transaction();
                        break;

                    case 2:
                        withdraw_money();
                        break;

                    case 3:
                        deposite_money();
                        break;

                    case 4:
                        System.out.println("\n" + "Total available balance: " + balance);
                        System.out.println();
                        break;

                    case 5:
                        transfer_money();
                        break;

                    case 6:
                        homepage_login();
                        break;

                    default:
                        System.out.println("\n" + "An error occured during transaction process...please try again...");
                        System.out.println();
                        break;
                }
            }
            catch(InputMismatchException e)
            {
                System.err.println("\n" + "Invalid entry.!!! Could you please try again later...");
                prompt();
            }
        }
    }

    public static void main(String[] args) {
        homepage_reg();
    }
}
