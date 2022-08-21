package ObjectOrientedProgramming;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
//        System.out.println(s1); // prints the address where s1 stores in student memory

        s1.name = "Mahesh";
//        s1.rollNo= 123;
        s1.setRollNo(123);


        s2.name="Madhur";
//        s2.rollNo = 121;
        s2.setRollNo(121);

        System.out.println(s1.name);
        System.out.println(s2.getRollNo());

    }
}
