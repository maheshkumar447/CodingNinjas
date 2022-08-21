package com.company;

import java.util.Scanner;

public class Break_Continuew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        boolean divided = false;
        for(int d =2; d<n;d++){
            if(n%d ==0){
                divided = true;
                break;
            }
        }

        if(divided){
            System.out.println("not prime");
        }else{
            System.out.println("prime");
        }

        int d = 2;
        divided = false;
        while(d<n){
            if(n%d==0){
                divided = true;
                break;
            }
            d = d+1;

        }
        if(divided){
            System.out.println("not prime");
        }
        else{
            System.out.println("prime");
        }
    }
}
