package Recursion;

public class NumberOfDigits {
    public static int count(int n){
        if(n == 0){
            return 0;
        }
        int smallAns = count(n / 10);
        return smallAns + 1;
    }

    public static void main(String[] args) {
       int ans= count(156);
        System.out.println(ans);
    }
}
