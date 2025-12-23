package Repositroy;

import domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository
{
    private final Map<String , Customer>customerByID=new HashMap<>();


    public List<Customer> findAll()
    {
        return  new ArrayList<>(customerByID.values());
    }

    public void save( String id,Customer c)
    {
        customerByID.put(id,c);
    }
}