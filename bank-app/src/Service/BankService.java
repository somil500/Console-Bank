package Service;

import domain.Account;
import domain.Transaction;

import java.util.List;

public interface BankService
{
     public String openAccount(String name, String email, String accountType);

     public List<Account> listofAccount();

     public  String deposit(String accountnumber, Double amount, String deposit);


      public    String withdraw(String accountnumber, Double amount, String withdraw);

     public Double Check(String account);

     public String transfer(String account1, String account2, Double amount);

     public  List<Transaction>getstatement(String account);

     List<Account>searchAccount(String q);
}
