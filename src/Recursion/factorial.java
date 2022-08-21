package Recursion;

public class factorial{

    public static int fact(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        int smallAns = fact(n-1);
        return n*smallAns;
    }

    public static void main(String[] args) {
//        int x = 3;
        int ans = fact(3);
        System.out.println(ans);

    }
}
