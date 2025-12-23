package Service;

import Repositroy.AccountRepository;
import Repositroy.CustomerRepository;
import Repositroy.TransactionRepository;
import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import exceptions.AccountNotFoundException;
import exceptions.InsufficientFoundException;
import util.Validation;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

//import java.util.*;
public class BankserviceImp implements BankService
{
    AccountRepository accountRepository=new AccountRepository();
TransactionRepository transactionRepository=new TransactionRepository();
CustomerRepository customerRepository=new CustomerRepository();
private final Validation<String>validationname=name->{
    if(name==null||name.isBlank()) throw  new RuntimeException("Invalid Name");
};

    @Override
    public String openAccount(String name, String email, String accountType)
    {
        validationname.validate(name);
       String customerID= UUID.randomUUID().toString();
      //String accountNumber=UUID.randomUUID().toString();
        int temp= accountRepository.findAll().size()+1;
        String accountNumber=String.format("AC%06d",temp);
        Account a= new Account(accountNumber,customerID,0.0,accountType);

        accountRepository.save(a);
        // Create customer
        Customer c=new Customer(email,customerID,name);
        customerRepository.save(customerID,c);

        return "Account Has successfully Opened Account Number:"+accountNumber;
    }

    @Override
    public List<Account> listofAccount()
    {

        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber)).toList();
    }

    @Override
    public String deposit(String accountnumber, Double amount, String deposit)
    {
        // Amount deposit
        Account account=accountRepository.findByNumber(accountnumber)
                .orElseThrow(()-> new AccountNotFoundException(" Account Not Found:"+accountnumber)) ;
        account.setBalance(account.getBalance()+amount);
        // Transaction

        Transaction transaction=new Transaction(UUID.randomUUID().toString(),
                Type.DEPOSIT,account.getAccountNumber(),amount, LocalDateTime.now(),deposit);

        transactionRepository.add(accountnumber,transaction);
        return "Money Has Successfully Deposit  In Account:"+accountnumber;
    }

    @Override
    public String withdraw(String accountnumber, Double amount, String withdraw)
    {
        // Amount deposit
        Account account=accountRepository.findByNumber(accountnumber)
                .orElseThrow(()-> new AccountNotFoundException(" Account Not Found:"+accountnumber)) ;
        if(account.getBalance()-amount>0)
        account.setBalance(account.getBalance()-amount);

        else
            throw  new InsufficientFoundException("Insufficient  Balance");
        // Transaction
        Transaction transaction=new Transaction(UUID.randomUUID().toString(),
                Type.WITHDRAW,account.getAccountNumber(),amount, LocalDateTime.now(),withdraw);

        transactionRepository.add(accountnumber,transaction);
        return " Amount Has Successfully withdraw From Account:"+accountnumber;
    }

    @Override
    public Double Check(String accountnumber)
    {
        Account account=accountRepository.findByNumber(accountnumber)
                .orElseThrow(()-> new RuntimeException(" Account Not Found:"+accountnumber)) ;


        return account.getBalance();
    }

    @Override
    public String transfer(String account1, String account2, Double amount)
    {

        if(account1.equals(account2))
            throw new RuntimeException("Money con not transfer in same account");
        // account 1 details
        Account from=accountRepository.findByNumber(account1)
                .orElseThrow(()-> new RuntimeException(" Account Not Found:"+account1)) ;
        //account 2 details
        Account to=accountRepository.findByNumber(account2)
                .orElseThrow(()-> new RuntimeException(" Account Not Found:"+account1)) ;


        if(from.getBalance()-amount>0) {
            from.setBalance(from.getBalance() - amount);
            // Transaction1
            Transaction transaction1=new Transaction(UUID.randomUUID().toString(),
                    Type.TRANSFER_IN,from.getAccountNumber(),amount, LocalDateTime.now(),"Paid");
            to.setBalance(to.getBalance() + amount);
            transactionRepository.add(transaction1.getAccountNumber(),transaction1);
            // Transaction2
            Transaction transaction2=new Transaction(UUID.randomUUID().toString(),
            Type.CREDITED,to.getAccountNumber(),amount, LocalDateTime.now(),"Received");
            transactionRepository.add(transaction2.getAccountNumber(),transaction2);


        }
        else
            throw  new RuntimeException("Insufficient  Balance");




        return "Money Has Successfully Transfered  TO Account Number:"+account2;
    }

    @Override
    public List<Transaction> getstatement(String account)
    {


        return transactionRepository.findByaccount(account).stream().
                sorted(Comparator.comparing(Transaction::getTimestamp)).toList();
    }

    @Override
    public List<Account> searchAccount(String q) {
        String query=(q==null)?"":q.toLowerCase();
        List<Account>result= new ArrayList<>();
        for(Customer c:customerRepository.findAll()){
            if(c.getName().toLowerCase().contains(query))
                result.addAll(accountRepository.findBycustomerId(c.getId()));
            result.sort(Comparator.comparing(Account::getAccountNumber));
        }
        return result;
    }

}
