package com.knoldus.OCP;

public class AppWithdrawService {
    private WithdrawableAcc withdrawableAccount;

    public AppWithdrawService(WithdrawableAcc withdrawableAccount) {
        this.withdrawableAccount = withdrawableAccount;
    }

    public void withdraw(double amount) {
        withdrawableAccount.withdraw(amount);
    }
}
