package ObjectOrientedProgramming;

public class Car extends Vehicle{
    int numGears;
    boolean isCOnvertible;

    public Car(int numGears){
        this.numGears = numGears;
        System.out.println("car constructor");

    }

    public void printCar(){
        System.out.println("Car color: " + color);
        System.out.println("Cra speed" + getMaxSpeed());
        System.out.println("car gears : " + numGears);
        System.out.println("car isCOnvertubible: " + isCOnvertible);
    }

    // agar m is uper wale fuction ka b naam print krdu i.e. jo ki Vehicle class me h
    // to kya hoyega jb hum isko VehicleUse me print krwayenge tb
    // jb hum isko print krwaynge to phle car class me print function dhundega compiler agar hua print to usi ko print kr dega
    // otherwise iske parent k pass jayega or usme dhundega agar wahan b nhi h to
    // to uske b parent k pass jayega or wahan dhundega

}
