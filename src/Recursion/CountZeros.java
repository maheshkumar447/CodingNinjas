package Recursion;

public class CountZeros {

    public static int countZerosRec(int input) {

        if (input < 10) {
            if (input == 0) {
                return 1;
            } else {
                return 0;
            }
        }

            int smallAns = countZerosRec(input / 10);
            if (input % 10 == 0) {
                smallAns = 1 + smallAns;
            }
            return smallAns;

    }


    public static void main(String[] args) {
        int x = 30452032;
        int ans = countZerosRec(x);
        System.out.println(ans);
    }
}
