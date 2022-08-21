package com.company;

import java.util.Scanner;

public class HalfDiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

       for(int i =0 ;i< n;i++){
           for(int j =0 ;j<(2*i+1);j++){
               System.out.print("*");
               for(j=1;j<2*i;j++){
                   System.out.print(i);
               }

           }
           System.out.println("");
       }
    }
}
