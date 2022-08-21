package com.company;

//public class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//        String a="coding";
//        for(int i=2;i<5;i++)
//        {
//            System.out.print(a.substring(i-2,i+1));
//        }
//    }
//}
//
//import java.util.Scanner;
//public class Main {
//
//    public static void main(String[] args) {
//        // Write your code here
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int cols = sc.nextInt();
//
//        for(int i=1; i<=row; i++){
//            for(int j=1; j<=i; j++){
//                System.out.print(" ");
//            }
//            for(int k=1; k<=cols; k++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//    }
//}



//class Vehicle {
//    public void Print() {
//        System.out.print("Vehicle's Print() ");
//    }
//}
//
//class FourWheelers extends Vehicle {
//    public void Print() {
//        System.out.print("FourWheelers's Print() ");
//    }
//}
//
//class Car extends FourWheelers {
//    public void Print() {
//        super.Print();
//        System.out.print("Car's Print()");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Car c = new Car();
//        c.Print();
//    }
//}




//class Car {
//    private int seats;
//    private int speed;
//
//    public Car() {
//        System.out.print("This Is Car ");
//    }
//}
//
//class Audi extends Car {
//    Audi() {
//        System.out.print("This Is Audi ");
////        super();   this is error kyunki super keyword likhna hmari phli priority h
//    }
//}
//
//class Main {
//    public static void main(String args[]) {
//        Audi a = new Audi();
//    }
//}




class Car {
    private int seats;
    private int speed;

    public Car(int seats, int speed) {
        this.seats = seats;
        this.speed = speed;
        System.out.print("This Is Car ");
    }
}

class Audi extends Car {
    Audi(int x, int y) {
        super(x,y);
        System.out.print("This Is Para Audi ");
    }
    void Audi() {
        System.out.print("This Is Def Audi");
    }
}

class Main {
    public static void main(String args[]) {
        Audi a = new Audi(5,7);
        a.Audi();
    }
}