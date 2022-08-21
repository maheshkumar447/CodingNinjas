package com.company;

import java.util.Scanner;

public class IntroTo2DARray {
    public static void main(String[] args) {
//        int arr2d[][] = new int[4][5];
//        System.out.println(arr2d[2][3]);
//        arr2d[1][2] = 17;
//        System.out.println(arr2d[1][2]);
//
//        int arr2[][] = {{1,3,5},{2,4,6}};

        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of rows: ");
        int rows = sc.nextInt();
        System.out.println("enter no of columns: ");
        int cols = sc.nextInt();

        int input[][] = new int[rows][cols];

        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                System.out.print("enter element at " + i +" row "+ j+ " column ");
                input[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
