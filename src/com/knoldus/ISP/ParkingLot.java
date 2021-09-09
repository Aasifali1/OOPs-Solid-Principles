package com.knoldus.ISP;

//Segregation means keeping things separated, and the Interface Segregation Principle is about separating the interfaces.

public interface ParkingLot {
    void parkCar();	// Decrease empty spot count by 1
    void unparkCar(); // Increase empty spots by 1
    void getCapacity();	// Returns car capacity
}

interface PaidParkingLot extends ParkingLot{
    double calculateFee(Car car, int hour); // Returns the price based on number of hours
    void doPayment(Car car);
}
interface FreeParkingLot extends ParkingLot{

}

class FreePark implements FreeParkingLot{

    @Override
    public void parkCar() {
        System.out.println("Car is parked");
    }

    @Override
    public void unparkCar() {
        System.out.println("Car is unparked");
    }

    @Override
    public void getCapacity() {
        System.out.println("Capcity: ");
    }
}

class Car implements PaidParkingLot{

    @Override
    public void parkCar() {
        System.out.println("Car is parked");
    }

    @Override
    public void unparkCar() {
        System.out.println("Car is unparked");
    }

    @Override
    public void getCapacity() {
        System.out.println("Capcity: ");
    }

    @Override
    public double calculateFee(Car car, int hour) {
        double pricePerHour = 10;
        double totalFee = pricePerHour * hour;
        return totalFee;
    }

    @Override
    public void doPayment(Car car) {
        System.out.println("Payment is initiated");
    }
}

class TestISP{

    static  void testPaid(Car car)
    {
        car.parkCar();
        car.getCapacity();
        car.doPayment(car);
        car.unparkCar();
       System.out.println(car.calculateFee(car,14));
    }
    static  void testFree(FreePark freePark){
        freePark.parkCar();
        freePark.getCapacity();
        freePark.unparkCar();
    }
    public static void main(String[] args)
    {
        Car car=new Car();
        testPaid(car);

        testFree(new FreePark());
    }

}
