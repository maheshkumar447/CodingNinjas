package vehicle_temp;

import ObjectOrientedProgramming.Vehicle;

public class Truck  extends Vehicle {

    int maxLoadingCapacity;
    public void print(){
        System.out.println("Truck Capacity: " + maxLoadingCapacity);
        System.out.println("Truck Color: " + color); // color nhi ho skta access because color is default i.e. friendly which means it is only aceess to package
         // so hmne color ko protected bnaya h
        System.out.println("Truck maxSPeed: " + getMaxSpeed());
    }

}
