package com.knoldus.OCP;

public class WithdrawableAcc extends Account{
    String name;
    double amount;
    public WithdrawableAcc(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
    }
    public void deposit(double amount){
        this.amount += amount;
        System.out.println("UPDATE: Rs. "+amount+" has been deposited into your account. Avl Bal INR "+this.amount);

    }
    public void withdraw(double amount){
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
