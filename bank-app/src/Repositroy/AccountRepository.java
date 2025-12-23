package Repositroy;

import domain.Account;

import java.util.*;

public class AccountRepository
{
    private  final Map<String , Account> accountsByNumber= new HashMap<>();
    public  void save(Account account)
    {
        accountsByNumber.put(account.getAccountNumber(),account);
    }

    public List<Account> findAll()
    {
        return  new ArrayList<>(accountsByNumber.values());
    }

    public Optional<Account> findByNumber(String accountnumber)
    {
        return Optional.ofNullable(accountsByNumber.get(accountnumber));
    }

    public List<Account> findBycustomerId(String id)
    {
        List<Account> result= new ArrayList<>();
        for(Account a:accountsByNumber.values()){
            if(a.getCustomerId().equals(id))
            result.add(a);
        }
        return result;
    }
}
