package com.knoldus.OCP;

public class FixedTermDepositAcc extends Account{

    String name;
    double amount;
    public FixedTermDepositAcc(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
    }
    public void deposit(double amount){
        this.amount += amount;
        System.out.println("Account Fixed Term Deposit UPDATE: Rs. "+amount+" has been deposited into your account. Avl Bal INR "+this.amount);
    }
}
