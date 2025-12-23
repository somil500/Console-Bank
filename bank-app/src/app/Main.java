package app;

import Service.BankService;
import Service.BankserviceImp;
import domain.Account;
import domain.Transaction;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        BankService BS=new BankserviceImp();
       boolean running =true;

        System.out.println("Welcome to Console Bank");
        while (running) {
            System.out.println("SELECT OPTIONS:");
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw 
                4) CheckBalance
                5) Transfer
                6) Account Statement
                7) Account List
                8) Search Account by Costumer Name
                0) Exit""");

            System.out.println();
            String choice= sc.nextLine().trim();
        // int choice= sc.nextInt();
            switch (choice)
            {
                case "1":
                    openAccount(sc,BS);
                break ;
                case "2":
                    deposit(sc,BS);
                break;
                case "3":
                    withdraw(sc,BS);
                break;
                case "4":
                    CheckBalance(sc,BS);
                break;

                case "5":
                    Transfer(sc,BS);
                    break;
                case "6":
                    AccountStatement(sc,BS);
                    break;
                case "7":
                    ListAccount(sc,BS);
                    break;

                case "8":
                    Search(sc,BS);
                    break;
                case "0":
                    running =false;
                    break;

            }
        }


    }


    private static void openAccount(Scanner sc,BankService BS)
    {
        System.out.println("Customer Name: ");
        String name=sc.nextLine().trim();
        System.out.println("Customer Email: ");
        String email=sc.nextLine().trim();
        System.out.println("Accont Type(SAVING/CURRENT): ");
        String type=sc.nextLine().trim();
     /*   System.out.println("Initial deposit : ");
        String Amount=sc.nextLine().trim();
        Double initial=Double.valueOf(Amount);*/
        System.out.println();
        System.out.println(BS.openAccount(name,email,type));

    }

    private static void deposit(Scanner sc, BankService BS)
    {

        try {
            System.out.println("Account Number:");
            String accountnumber=sc.nextLine().trim();
            System.out.println("Amount:");
            Double amount=Double.valueOf(sc.nextLine().trim());
            System.out.println( BS.deposit(accountnumber,amount,"Deposit"));
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private static void withdraw(Scanner sc ,BankService BS)
    {
        try {
            System.out.println("Account Number:");
            String accountnumber=sc.nextLine().trim();
            System.out.println("Amount:");
            Double amount=Double.valueOf(sc.nextLine().trim());
            System.out.println( BS.withdraw(accountnumber,amount,"Withdraw"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void CheckBalance(Scanner sc, BankService BS)
    {
        try {
            System.out.println("Account Number:");
            String account=sc.nextLine().trim();
            System.out.println(
                    "Available Balance "+BS.Check(account));

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void Transfer(Scanner sc, BankService BS) {
        try {
            System.out.println("From Account:");
            String account1=sc.nextLine().trim();
            System.out.println("To Account:");
            String account2=sc.nextLine().trim();
            System.out.println("Amount:");
            Double amount=Double.valueOf(sc.nextLine().trim());

            System.out.println(
                    "Transfer Amount "+BS.transfer(account1,account2,amount));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void AccountStatement(Scanner sc, BankService BS)
    {
        try {
            System.out.println("Account Number:");
            String account=sc.nextLine().trim();
            BS.getstatement(account).forEach(X->
            {
                System.out.println("---------Transaction Details:----------");
                System.out.println("Account:"+X.getAccountNumber()
                    +"|Id:"+X.getId()+"|Amount:"+X.getAmount()
            +"|Date-Time:"+X.getTimestamp()+"|Type:"+X.getType()+"|Message:"+X.getNote());
            });

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void ListAccount(Scanner sc,BankService BS)
    {
        System.out.println("LIST OF ALL ACCOUNT IN BANK");
        int count=0;
        for (Account account : BS.listofAccount()) {
           count++;
            System.out.println(" --------ACCOUNT :"+count+" DETAILS--------------");

            System.out.println("Account Number:"+account.getAccountNumber());

            System.out.println("Account Type:"+account.getAccountTtype());

        }
        System.out.println();
    }

    private static void Search(Scanner sc,BankService BS)
    {
        try {
            System.out.println("Customer name:");
            String q = sc.nextLine().trim();
            BS.searchAccount(q).
                    forEach(a ->
                            System.out.println("Account:" + a.getAccountNumber() +
                                    "| Type:" + a.getAccountTtype() + "| Balance:"
                                    + a.getBalance()));
        } catch (Exception e) {
            System.out.println(e);
        }



    }



}