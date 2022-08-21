package com.company;

import java.util.Scanner;

public class NcR {




    public static int factorial(int n){
        int ans = 1;
        for(int i =1; i<=n;i++){
            ans =  ans*i;
        }
        return ans;
    }

    public static boolean isPrime(int n){
        int d =2;
        while(d<n){
            if(n%d==0){
                return false;  // divide ho gya to prime nhi h
            }
            d++; // agar if ne nhi gya to d ko increase krdo ek se or dobara check kro condiiton
        }
        return true; // agar last tk wo kisi se divide nhi hua to print true
    }


    public static void printNumber(int n){
        if(n<=0){
            return;
        }
        for(int i =1; i<=n ; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();


//        int num  = 1;
//        for(int i =1; i<=n;i++){
//            num = num * i;
//        }

        int num = factorial(n);

//        int den1 = 1;
//        for(int i =1;i<=r;i++){
//            den1 = den1*i;
//        }

        int den1 = factorial(r);


//        int den2 = 1;
//        for(int i = 1; i<=n-r ;i++){
//            den2 = den2*i;
//        }

        int den2 = factorial(n-r);

        int ans = num/(den1*den2);
        System.out.println(ans);



        boolean ansPrime = isPrime(13);
        System.out.println(ansPrime);



        printNumber(6);
    }
}
