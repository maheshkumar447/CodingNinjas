package ObjectOrientedProgramming;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.color = "BLack";
        v.setMaxSpeed(10);
        v.print();

        Car c = new Car(10);
//        c.numGears = 10;  uper pass krdiye to yahan likhne ki jrurt nhi
        c.color="BlACK";
        c.print();

        c.setMaxSpeed(10);
        c.printCar();
    }
}
