package com.company;

public class SumOfDigits {

    public static int sumOfDigits(int input){
        // Write your code here
        if(input ==0 ){
            return 0;
        }

        return input%10+sumOfDigits(input/10);
    }

    public static void main(String[] args) {
        int n = 12345;
        int ans = sumOfDigits(n);
        System.out.println(ans);
    }
}
