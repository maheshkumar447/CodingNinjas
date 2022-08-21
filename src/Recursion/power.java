package Recursion;

public class power {

    public static int powers(int x, int n){

        if(n==0){
            return 1;

        }

        if(n==1){
            return x;
        }
        int smallAns = powers(x,n-1);

        return x*smallAns;
    }

    public static void main(String[] args) {
//        int x= 2;
//        int n =5;

        int ans = powers(2,5);
        System.out.println(ans);
    }
}
