package com.knoldus.OCP;

public class Test {
    public static void main(String[] args)
    {
        WithdrawableAcc acc =new WithdrawableAcc("Aasif", 345.00);
        acc.deposit(45.40);
        acc.withdraw(45.40);

        Account myFixedTermDepositAccount = new FixedTermDepositAcc("Aasif",2400.15);
        myFixedTermDepositAccount.deposit(1000.00);

        AppWithdrawService withdrawalService = new AppWithdrawService(acc);
        withdrawalService.withdraw(100.00);

    }
}
