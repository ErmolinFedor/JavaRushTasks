package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected final int MAX_TRUCK_SPEED = 80;
    protected final int MAX_SEDAN_SPEED = 120;
    protected final int MAX_CABRIOLET_SPEED = 90;
    public static Car create(int type, int numberOfPassengers){
        Car car = null;
        switch (type){
            case 0 : car = new Truck(numberOfPassengers);
            break;
            case 1 : car = new Sedan(numberOfPassengers);
            break;
            case 2 : car = new Cabriolet(numberOfPassengers);
            break;
        }
        return car;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
                throw new Exception("Exception class: Car fill");
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){
        return (date.after(summerStart) && date.before(summerEnd));
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        return isSummer(date , SummerStart , SummerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        //return canPassengersBeTransferred() ? numberOfPassengers : 0 ;
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;
    }

    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() && fuel > 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed() ;
}