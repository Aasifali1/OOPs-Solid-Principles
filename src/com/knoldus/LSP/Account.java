package com.knoldus.LSP;

public abstract class Account {
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

class SavingAccount extends Account{
    String name;
    double amount;
    public SavingAccount(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void deposit(double amount) {
        this.amount += amount;
        System.out.println("UPDATE: Rs. "+amount+" has been deposited into your account. Avl Bal INR "+this.amount);
    }

    @Override
    public void withdraw(double amount) {
        if(this.amount > amount)
        {
            this.amount -= amount;
            System.out.println("ALERT: You've withdrawn Rs. "+amount+" Available Bal Rs.  "+this.amount);
        }
        else {
            System.out.println("You don't have enough balance. The current balance is "+this.amount);
        }
    }
}
class CurrentAccount extends Account{
    String name;
    double amount;
    public CurrentAccount(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void deposit(double amount) {
        this.amount += amount;
        System.out.println("UPDATE: Rs. "+amount+" has been deposited into your account. Avl Bal INR "+this.amount);
    }

    @Override
    public void withdraw(double amount) {
        if(this.amount > amount)
        {
            this.amount -= amount;
            System.out.println("ALERT: You've withdrawn Rs. "+amount+" Available Bal Rs.  "+this.amount);
        }
        else {
            System.out.println("You don't have enough balance. The current balance is "+this.amount);
        }
    }
}

class TestLSP{
    public static void test(Account account , double amount)
    {
        account.deposit(amount);
        account.withdraw(amount);
    }

    public static void main(String[] args)
    {

        Account savingAccount=new SavingAccount("Aasif Ali", 4500.45);
        Account currentAccount =new CurrentAccount("Sajal", 8000.66);

//      The Liskov Substitution Principle states that subclasses should be substitutable for their base classes.

        test(savingAccount,800.44);
        test(currentAccount,4000.44);
    }

}