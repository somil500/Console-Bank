package Repositroy;

import domain.Transaction;

import java.util.*;

public class TransactionRepository
{
    private  final Map<String, List<Transaction>>transactions=new HashMap<>();

    public void add(String accountnumber, Transaction transaction)
    {
        transactions.computeIfAbsent(transaction.getAccountNumber(),k->new ArrayList<>()).add(transaction);

    }

    public List<Transaction> findByaccount(String account)
    {
        return  new ArrayList<>(transactions.getOrDefault(account, Collections.emptyList()));

    }
}
