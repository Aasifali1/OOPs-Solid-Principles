# OOPs_Solid_Principles

![Solid Design ](https://img.shields.io/badge/Solid_Design-Principles--in--Java-green.svg?longCache=true&style=for-the-badge)

 
## Open-Closed Principle (OCP)
The Open-Closed Principle requires that classes should be open for extension and closed to modification.
Without the Open/Closed Principle

### Without the Open/Closed Principle

![This is an image](https://www.baeldung.com/wp-content/uploads/2020/07/1.png)

Unfortunately, there is a problem with extending this design. The AppWithdrawalService is aware of the two concrete implementations of account. Therefore, the BankingAppWithdrawalService would need to be changed every time a new account type is introduced.

```java
public abstract class Account {
    protected abstract void deposit(double amount);

    protected abstract void withdraw(double amount);
}
```
![This is an image](https://www.baeldung.com/wp-content/uploads/2020/07/2.png)

 Here, we introduced a new abstract Account class that CurrentAccount and SavingsAccount extend.

```java
public abstract class Account {
   public abstract void deposit(double amount);
}
```
 
Consequently, the BankingAppWithdrawalService is open for the extension with new account types, but closed for modification, in that the new types don't require it to change in order to integrate.


```java
public class AppWithdrawService {
   private WithdrawableAcc withdrawableAccount;

   public AppWithdrawService(WithdrawableAcc withdrawableAccount) {
       this.withdrawableAccount = withdrawableAccount;
   }

   public void withdraw(double amount) {
       withdrawableAccount.withdraw(amount);
   }
}
```

## Liskov Substitution Principle (LSP)

The Liskov Substitution Principle states that subclasses should be substitutable for their base classes.

This means that, given that class B is a subclass of class A, we should be able to pass an object of class B to any method that expects an object of class A and the method should not give any weird output in that case.

```java
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
```


In the above example there is two objects of SavingAccount class and CurrentAccount class both classes are subtype of Account class.

given that class SavingAccount is a subclass of class Account, we are passing the objects of class SavingAccount and CurrentAccount to the test method given in above code method that expects an object of class Account and the method  gives the desired output.

```java
class CurrentAccount extends Account{
  @Override
   public void deposit(double amount) {
  
   }
   @Override
   public void withdraw(double amount) {
  
   }
}

class SavingAccount extends Account{


   @Override
   public void deposit(double amount) {

   }

   @Override
   public void withdraw(double amount) {

   }
}
```

## Interface Segregation Principle (ISP)

Segregation means keeping things separated, and the Interface Segregation Principle is about separating the interfaces.

```java 
public interface ParkingLot {

	void parkCar();	// Decrease empty spot count by 1
	void unparkCar(); // Increase empty spots by 1
	void getCapacity();	// Returns car capacity
	double calculateFee(Car car); // Returns the price based on number of hours
	void doPayment(Car car);
}
```

We modeled a very simplified parking lot. It is the type of parking lot where you pay an hourly fee. Now consider that we want to implement a parking lot that is free.
But it is too specific. Because of that, our FreeParking class was forced to implement payment-related methods that are irrelevant. Let's separate or segregate the interfaces.

![This is an image](https://erinc.io/wp-content/uploads/2020/08/SOLID-Tutorial-1024x432.png)

We've now separated the parking lot. With this new model, we can even go further and split the PaidParkingLot to support different types of payment.

```java
public interface ParkingLot {
   void parkCar();    // Decrease empty spot count by 1
   void unparkCar(); // Increase empty spots by 1
   void getCapacity();    // Returns car capacity
}

interface PaidParkingLot extends ParkingLot{
   double calculateFee(Car car, int hour); // Returns the price based on number of hours
   void doPayment(Car car);
}
interface FreeParkingLot extends ParkingLot{

}
```

