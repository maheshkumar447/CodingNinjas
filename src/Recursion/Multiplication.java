package Recursion;

public class Multiplication {

    public static int multiplyTwoIntegers(int m, int n){

        if(n==1){
            return m;
        }
        int smallAns = m+multiplyTwoIntegers(m,n-1);
        return smallAns;


    }

    public static void main(String[] args) {
        int x = 3;
        int y =5;
        int ans = multiplyTwoIntegers(x,y);
        System.out.println(ans);
    }
}
