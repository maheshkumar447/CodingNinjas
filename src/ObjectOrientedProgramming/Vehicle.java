package ObjectOrientedProgramming;

public class Vehicle {
//    String color;
    protected String color;
    private int maxSpeed;  // ye private bna diya to ye access nhi ho skta
    // isko access jrne k liye we use getters and setters

    public Vehicle(){
        System.out.println("Vehicle constructor");
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }


    public void print(){
        System.out.println("vehicle color " + color);
        System.out.println("vehucle speed: " + maxSpeed);
    }
}
