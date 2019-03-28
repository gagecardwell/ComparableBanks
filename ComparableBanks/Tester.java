
import java.io.*;
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (Gage Cardwell) 
 * @version (3/14/2019)
 */
public class Tester
{
    public static void main(String[] args) throws IOException
    {
        String[] arr = ReadFromFile.ReadFile("C:/Users/amossm/Desktop/Blah/comparableBanks/Bank of OSSM.txt");
        Bank b = new Bank("Bank of Ossm", 2);
        b.addAccount(new BankAccount("Bob", 1000,8) );
        b.addAccount(new SavingsAccount("Sam", 500, 0.04, 2) );
        b.addAccount(new BankAccount("John", 250, 5) );
        Scanner kb = new Scanner(System.in);
        System.out.println("Would you like to add a new account?");
        String newBank = kb.nextLine();
        System.out.println("How many bank accounts will you be adding?");
        int NumBanks = kb.nextInt();
        if(newBank.equals("yes"))
        {
            for(int i = 0;i < NumBanks; i ++)
            {
                
                System.out.println("Please enter the number of employees of the new bank.");
                int numEmployees = kb.nextInt();
                Scanner kb2 = new Scanner(System.in);
                System.out.println("Will this account be a Savings Account or Bank Account?");
                String AccountType = kb2.nextLine();

                if(AccountType.contains("Savings"))
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("What is your name?");
                    String name = sc.nextLine();

                    Scanner kb3 = new Scanner(System.in);
                    System.out.println("What is the rate of the Savings Account?");
                    double rate = kb3.nextDouble();

                    System.out.println("How much money will your account start with?");
                    double amount = kb3.nextDouble();

                    b.addAccount(new SavingsAccount(name , amount, rate, numEmployees) );
                    
                }

                else if(AccountType.contains("Bank"))
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("What is your name?");
                    String name = sc.nextLine();
                    
                    System.out.println("How much money will your account start with?");
                    double amount = kb.nextDouble();

                    b.addAccount( new BankAccount(name, amount, numEmployees) );
                }
                else
                {
                    System.out.println("Please enter a valid type of account, or capitalize your answer.");
                }
            }
        }
        System.out.println("Would you like to sort the bank accounts by name, type, or number?");
        Scanner s = new Scanner(System.in);
        String sortType = s.nextLine();
        if(sortType.contains("name"))
        {
            BankAccount[] accounts = new BankAccount[1];

            accounts = b.getAccounts().toArray(accounts);

            AccountNameComparator anc = new AccountNameComparator();
            Arrays.sort( accounts, anc);

            for( int g = 0; g < accounts.length; g++)
            {
                System.out.println( accounts[g] );
            }
            System.out.println( b );
        }
        else if(sortType.contains("type"))
        {
            BankAccount[] accounts = new BankAccount[1];

            accounts = b.getAccounts().toArray(accounts);

            AccountTypeComparator anc = new AccountTypeComparator();
            Arrays.sort( accounts, anc);

            for( int g = 0; g < accounts.length; g++)
            {
                System.out.println( accounts[g] );
            }
            System.out.println( b );
        }
        else
        {
            BankAccount[] accounts = new BankAccount[1];

            accounts = b.getAccounts().toArray(accounts);

            AccountNumComparator anc = new AccountNumComparator();
            Arrays.sort( accounts, anc);
            
            for( int g = 0; g < accounts.length; g++)
            {
                System.out.println( accounts[g] );
            }
            System.out.println( b );
        }
         FileWriter fw = new FileWriter("C:/Users/amossm/Desktop/Blah/comparableBanks/Bank of OSSM.txt");

        PrintWriter pw = new PrintWriter(fw);
        String ss = b.toString();
        Scanner scan = new Scanner(ss);
        while(scan.hasNext())
        {
            pw.println(scan.nextLine());
        }
        pw.close();
        fw.close();
    }
}