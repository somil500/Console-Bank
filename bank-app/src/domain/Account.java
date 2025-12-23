package domain;

public class Account
{
    private String accountNumber;
    private String customerId;
    private Double balance;
    private String AccountTtype;

    public Account(String accountNumber, String customerId, Double balance, String accountTtype) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        AccountTtype = accountTtype;
    }

    public String getAccountNumber() {
        return  accountNumber;
    }

    public String getAccountTtype() {
        return AccountTtype;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
