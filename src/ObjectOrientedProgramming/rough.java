package ObjectOrientedProgramming;

class St{
    String name;
    int rollno;
    St(int  num){
        rollno = num;
    }
    public  void print(){
        System.out.println(name+""+rollno+"");
    }
}

public class rough {
    public static void main(String[] args) {
        St s = new St(12);
        s.print();
    }
}
