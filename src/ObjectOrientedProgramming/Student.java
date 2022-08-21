package ObjectOrientedProgramming;

public class Student {
    String name;
//    int rollNo;

    private int rollNo;

    public void setRollNo(int rn){

        if(rn<=0){
            return;
        }

        rollNo = rn;
    }

    public int getRollNo(){
        return rollNo;
    }
}
